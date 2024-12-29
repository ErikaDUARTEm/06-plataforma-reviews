package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.services.reviews.restaurantReview.AddRestaurantReview;

public class AddRestaurantReviewController implements IController {
  private AddRestaurantReview restaurantReviewCommand;

  public AddRestaurantReviewController(AddRestaurantReview restaurantReviewCommand) {
    this.restaurantReviewCommand = restaurantReviewCommand;
  }

  @Override
  public void execute() {
    restaurantReviewCommand.execute();
  }
}
