package org.example.controllers.user;

import org.example.controllers.interfaces.IController;
import org.example.services.user.ShowUser;


public class ShowUserController implements IController {

  private ShowUser command;

  public ShowUserController(ShowUser command){
    this.command = command;
  }

  private ShowUserController() {
  }

  @Override
  public void execute() {

    System.out.println("Todos los usuarios registrados:");
    command.execute();
  }
}
