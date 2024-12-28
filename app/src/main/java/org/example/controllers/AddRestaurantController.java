package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.services.restaurant.AddRestaurant;


public class AddRestaurantController implements IController {
  private final AddRestaurant command;

  public AddRestaurantController(AddRestaurant command) {
    this.command = command;
  }

  @Override
  public void execute() {
    command.execute();
    System.out.println("Restaurante agregado exitosamente.");
  }
}
