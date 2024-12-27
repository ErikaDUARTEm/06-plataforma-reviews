package org.example.factory;

import org.example.models.Dish;
import org.example.models.DishReview;
import org.example.models.Review;

public class DishReviewFactory implements IReviewFactory<Dish>{

  @Override
  public Review createReview(int rating, String comment, Dish dish) {
    return new DishReview(rating, comment, dish,4,5);
  }
}
