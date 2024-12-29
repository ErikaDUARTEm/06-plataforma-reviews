package org.example.controllers.restaurants;

import org.example.controllers.interfaces.IController;
import org.example.services.restaurant.DeleteRestaurant;

public class DeleteRestaurantController implements IController {
  private DeleteRestaurant command;

  public DeleteRestaurantController(DeleteRestaurant command) {
    this.command = command;
  }

  private DeleteRestaurantController() {
  }

  @Override
  public void execute() {
    command.execute();
  }
}
