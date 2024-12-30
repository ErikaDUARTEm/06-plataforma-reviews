import org.example.models.NotificationService;
import org.example.services.user.DisableNotifications;
import org.example.utils.IHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DisableNotificationsTest {

  @Mock
  private IHandler mockHandler;

  @Mock
  private NotificationService mockNotificationService;

  @InjectMocks
  private DisableNotifications disableNotifications;


  @Test
  public void testExecuteUserNotFound() {
    // Given
    when(mockHandler.readLine()).thenReturn("NonExistentName", "nonexistent@example.com", "Si");

    // When
    disableNotifications.execute();

    // Then
    verify(mockHandler).writeLine("Escribe tu nombre:");
    verify(mockHandler).writeLine("Escribe tu email:");
    verify(mockHandler).writeLine("Si deseas desactivar las notificaciones escribe 'Si'");
    verify(mockHandler).writeLine("No se encontro el usuario en la lista de suscritos");
  }

  @Test
  public void testValidateNameEmpty() {
    // Given
    when(mockHandler.readLine()).thenReturn("   ");

    // When
    disableNotifications.disableNotification();

    // Then
    verify(mockHandler).writeLine("El nombre no puede ser vacio.");
  }

  @Test
  public void testValidateEmailEmpty() {
    // Given
    when(mockHandler.readLine()).thenReturn("example@example.com", "   ");

    // When
    disableNotifications.disableNotification();

    // Then
    verify(mockHandler).writeLine("Escribe tu email:");
    verify(mockHandler).writeLine("El email no puede ser vacio.");
  }

  @Test
  public void testExecuteInvalidOption() {
    // Given
    when(mockHandler.readLine()).thenReturn("John", "john@example.com", "No");

    // When
    disableNotifications.execute();

    // Then
    verify(mockHandler).writeLine("Escribe tu nombre:");
    verify(mockHandler).writeLine("Escribe tu email:");
    verify(mockHandler).writeLine("Si deseas desactivar las notificaciones escribe 'Si'");
    verify(mockHandler).writeLine("Escribe la palabra correcta para desactivar las notificaciones.");
  }
}
