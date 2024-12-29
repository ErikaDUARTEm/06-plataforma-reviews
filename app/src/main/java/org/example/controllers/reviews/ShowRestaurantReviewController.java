package org.example.controllers.reviews;

import org.example.controllers.interfaces.IController;
import org.example.services.reviews.restaurantReview.ShowRestaurantReview;

public class ShowRestaurantReviewController implements IController {
  private ShowRestaurantReview command;

  public ShowRestaurantReviewController(ShowRestaurantReview command) {
    this.command = command;
  }

  private ShowRestaurantReviewController() {
  }

  @Override
  public void execute() {
    command.execute();
  }
}
