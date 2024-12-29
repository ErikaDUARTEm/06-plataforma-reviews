package org.example.controllers.restaurants;

import org.example.controllers.interfaces.IController;
import org.example.services.restaurant.UpdateRestaurant;

public class UpdateRestaurantController implements IController {
  private UpdateRestaurant command;

  public UpdateRestaurantController(UpdateRestaurant command){
    this.command = command;
  }

  private UpdateRestaurantController() {
  }

  @Override
  public void execute() {
    command.execute();
  }
}
