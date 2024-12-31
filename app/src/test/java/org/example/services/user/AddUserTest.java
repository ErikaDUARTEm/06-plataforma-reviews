package org.example.services.user;

import org.example.utils.NotificationService;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.utils.IHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AddUserTest {

  @Mock
  private UserRepository mockRepository;
  @Mock
  private IHandler mockHandler;
  @Mock
  private NotificationService mockNotificationService;
  @InjectMocks
  private AddUser addUser;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }
  @Test
  @DisplayName("Agregar nuevo usuario")
  void testExecute() {

    when(mockHandler.readLine()).thenReturn("Erika", "erika@gmail.com");

    User result = addUser.execute();

    verify(mockHandler).writeLine("Ingresa el nombre del usuario:");
    verify(mockHandler).writeLine("Ingresa el email:");

    ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
    verify(mockNotificationService).addObserver(userCaptor.capture());
    verify(mockRepository).addUser(userCaptor.capture());

    User capturedUser = userCaptor.getValue();
    assertEquals("Erika", capturedUser.getName());
    assertEquals("erika@gmail.com", capturedUser.getEmail());

    assertEquals(capturedUser, result);
  }
}