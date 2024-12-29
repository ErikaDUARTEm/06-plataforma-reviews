package org.example.controllers.restaurants;

import org.example.controllers.interfaces.IController;
import org.example.services.restaurant.ShowRestaurants;

public class ShowRestaurantsController implements IController {
  private ShowRestaurants command;

  public ShowRestaurantsController(ShowRestaurants command){
    this.command = command;
  }

  private ShowRestaurantsController() {
  }

  @Override
  public void execute() {
    command.execute();
  }
}
