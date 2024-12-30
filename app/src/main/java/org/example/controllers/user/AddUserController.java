package org.example.controllers.user;

import org.example.controllers.interfaces.IController;
import org.example.services.user.AddUser;


public class AddUserController implements IController {
  private AddUser command;

  public AddUserController(AddUser command){
    this.command = command;
  }

  private AddUserController() {
  }

  @Override
  public void execute() {
    command.execute();
    System.out.println("Usuario agregado exitosamente. ");
  }
}
