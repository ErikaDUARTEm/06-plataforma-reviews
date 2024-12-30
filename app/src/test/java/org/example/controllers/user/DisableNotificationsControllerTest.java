package org.example.controllers.user;

import org.example.services.user.DisableNotifications;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class DisableNotificationsControllerTest {

  @Mock
  private DisableNotifications command;

  @InjectMocks
  private DisableNotificationsController controller;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }
  @Test
  void testExecute() {
    controller.execute();
    verify(command).execute();
  }
}
