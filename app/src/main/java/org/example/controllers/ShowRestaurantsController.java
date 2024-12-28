package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.services.restaurant.ShowRestaurants;

public class ShowRestaurantsController implements IController {
  private final ShowRestaurants command;

  public ShowRestaurantsController(ShowRestaurants command){
    this.command = command;
  }
  @Override
  public void execute() {
    command.execute();
  }
}
