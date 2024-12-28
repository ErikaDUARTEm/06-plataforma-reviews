package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.models.User;
import org.example.services.user.AddUser;


public class AddUserController implements IController {
  private final AddUser command;

  public AddUserController(AddUser command){
    this.command = command;
  }


  @Override
  public void execute() {
    User user = command.execute();
    System.out.println("Usuario agregado exitosamente. ");
  }

}
