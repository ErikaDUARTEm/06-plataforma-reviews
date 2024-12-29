package org.example.controllers.reviews;

import org.example.controllers.interfaces.IController;
import org.example.services.reviews.dishReview.ShowDishReview;

public class ShowDishReviewController implements IController {
  private ShowDishReview command;

  public ShowDishReviewController(ShowDishReview command) {
    this.command = command;
  }

  private ShowDishReviewController() {
  }

  @Override
  public void execute() {
    command.execute();
  }
}
