package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.services.user.ShowUser;


public class ShowUserController implements IController {

  private final ShowUser command;

  public ShowUserController(ShowUser command){
    this.command = command;
  }


  @Override
  public void execute() {

    System.out.println("Todos los usuarios registrados:");
    command.execute();

  }

}
