package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.services.reviews.restaurantReview.ShowRestaurantReview;

public class ShowRestaurantReviewController implements IController {
  private ShowRestaurantReview command;

  public ShowRestaurantReviewController(ShowRestaurantReview command) {
    this.command = command;
  }

  @Override
  public void execute() {
    command.execute();
  }
}
