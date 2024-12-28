package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.services.restaurant.DeleteRestaurant;

public class DeleteRestaurantController implements IController {
  private final DeleteRestaurant command;

  public DeleteRestaurantController(DeleteRestaurant command) {
    this.command = command;
  }

  @Override
  public void execute() {
    command.execute();
  }
}
