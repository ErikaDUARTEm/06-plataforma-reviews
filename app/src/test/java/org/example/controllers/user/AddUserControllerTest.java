package org.example.controllers.user;

import org.example.services.user.AddUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

class AddUserControllerTest {

  @Mock
  private AddUser mockAddUser;

  @InjectMocks
  private AddUserController addUserController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("se verifica que AddUser.execute() es llamado")
  void testExecute() {
    addUserController.execute();

    verify(mockAddUser).execute();
  }


  @Test
  @DisplayName("que se imprima el mensaje")
  void testExecutePrintsMessage() {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    addUserController.execute();

    assertTrue(outContent.toString().contains("Usuario agregado exitosamente."));

    System.setOut(System.out);
  }
}