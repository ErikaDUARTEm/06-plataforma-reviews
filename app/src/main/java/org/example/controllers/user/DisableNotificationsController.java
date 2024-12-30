package org.example.controllers.user;

import org.example.controllers.interfaces.IController;
import org.example.services.user.DisableNotifications;

public class DisableNotificationsController implements IController {
  public DisableNotifications command;

  public DisableNotificationsController(DisableNotifications disableNotificationsCommand) {
    this.command = disableNotificationsCommand;
  }

  private DisableNotificationsController() {
  }

  @Override
  public void execute() {
    command.execute();
  }
}
