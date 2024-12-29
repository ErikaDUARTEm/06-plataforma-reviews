package org.example.controllers;

import org.example.controllers.interfaces.IController;
import org.example.services.reviews.dishReview.AddDishReview;

public class AddDishReviewController implements IController {
  private AddDishReview command;

  private AddDishReviewController() {
  }

  public AddDishReviewController(AddDishReview command) {
    this.command = command;
  }

  @Override
  public void execute() {
    command.execute();
  }
}
