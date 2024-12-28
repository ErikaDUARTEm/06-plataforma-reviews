package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.services.restaurant.UpdateRestaurant;

public class UpdateRestaurantController implements IController {
  private UpdateRestaurant command;

  public UpdateRestaurantController(UpdateRestaurant command){
    this.command = command;
  }

  @Override
  public void execute() {
    command.execute();
  }
}
