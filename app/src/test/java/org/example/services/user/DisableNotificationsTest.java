package org.example.services.user;

import org.example.models.NotificationService;
import org.example.models.User;
import org.example.services.interfaces.IObserver;
import org.example.utils.IHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

class DisableNotificationsTest {

  @Mock
  private IHandler mockHandler;

  @Mock
  private NotificationService mockNotificationService;

  @InjectMocks
  private DisableNotifications disableNotifications;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Se desactiva la notificacion")
  void testExecuteSuccessfulDisable() {

    when(mockHandler.readLine()).thenReturn("Erika", "erika@gmail.com", "Si");

    User user = new User("Erika", "erika@gmail.com");
    List<IObserver> observers = new LinkedList<>();
    observers.add(user);
    when(mockNotificationService.getObservers()).thenReturn((LinkedList<IObserver>) observers);

    disableNotifications.execute();

    verify(mockHandler).writeLine("Escribe tu nombre:");
    verify(mockHandler).writeLine("Escribe tu email:");
    verify(mockHandler).writeLine("Si deseas desactivar las notificaciones escribe 'Si'");
    verify(mockHandler).writeLine("Acción exitosa, no recibirás más notificaciones");

    verify(mockNotificationService).removeObserve(user);
  }

  @Test
  @DisplayName("Usuario no encontrado")
  void testExecuteUserNotFound() {
    when(mockHandler.readLine()).thenReturn("Erika", "erika@gmail.com", "Si");

    LinkedList<IObserver> observers = new LinkedList<>();
    when(mockNotificationService.getObservers()).thenReturn(observers);

    disableNotifications.execute();

    verify(mockHandler).writeLine("Escribe tu nombre:");
    verify(mockHandler).writeLine("Escribe tu email:");
    verify(mockHandler).writeLine("Si deseas desactivar las notificaciones escribe 'Si'");
    verify(mockHandler).writeLine("No se encontro el usuario en la lista de suscritos");

    verify(mockNotificationService, never()).removeObserve(any(IObserver.class));
  }

  @Test
  @DisplayName("Usuario escribe algo distinto a si")
  void testExecuteUserDoesNotConfirm() {
    when(mockHandler.readLine()).thenReturn("Erika", "erika@gmail.com", "No");

    disableNotifications.execute();

    verify(mockHandler).writeLine("Escribe tu nombre:");
    verify(mockHandler).writeLine("Escribe tu email:");
    verify(mockHandler).writeLine("Si deseas desactivar las notificaciones escribe 'Si'");
    verify(mockHandler).writeLine("Escribe la palabra completa.");

    verify(mockNotificationService, never()).removeObserve(any(IObserver.class));
  }
}
