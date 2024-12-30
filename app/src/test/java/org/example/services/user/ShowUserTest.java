package org.example.services.user;

import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.utils.IHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ShowUserTest {
  @Mock
  private UserRepository mockRepository;

  @Mock
  private IHandler mockHandler;

  @InjectMocks
  private ShowUser showUser;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Mostrar todos los usuarios")
  void testExecute() {
    List<User> users = Arrays.asList(
      new User("Erika", "erika@gmail.com"),
      new User("Juan", "juan@gmail.com")
    );

    LinkedList<User> linkedListUsers = new LinkedList<>(users);

    when(mockRepository.getAllUsers()).thenReturn(linkedListUsers);
    showUser.execute();

    verify(mockHandler).writeLine("Nombre de usuario: Erika | Email: erika@gmail.com");
    verify(mockHandler).writeLine("Nombre de usuario: Juan | Email: juan@gmail.com");
    verify(mockRepository).getAllUsers();
  }
}