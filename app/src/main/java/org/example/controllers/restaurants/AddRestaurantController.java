package org.example.controllers.restaurants;

import org.example.controllers.interfaces.IController;
import org.example.services.restaurant.AddRestaurant;

public class AddRestaurantController implements IController {
  private AddRestaurant command;

  public AddRestaurantController(AddRestaurant command) {
    this.command = command;
  }

  private AddRestaurantController() {
  }

  @Override
  public void execute() {
    command.execute();
    System.out.println("Restaurante agregado exitosamente.");
  }
}
