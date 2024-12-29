package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.services.reviews.dishReview.ShowDishReview;

public class ShowDishReviewController implements IController {
  private ShowDishReview command;

  public ShowDishReviewController(ShowDishReview command) {
    this.command = command;
  }

  @Override
  public void execute() {
    command.execute();
  }
}
