package org.example.factory;

import org.example.models.Dish;
import org.example.models.reviews.DishReview;
import org.example.models.reviews.Review;

public class DishReviewFactory implements IReviewFactory<Dish>{

  @Override
  public Review createReview(int rating, String comment, Dish dish, Integer... additionalRatings) {
    if(additionalRatings.length < 2){
      throw new IllegalArgumentException("Faltan calificaciones adicionales");
    }
    Integer flavorRating = additionalRatings[0];
    Integer presentationRating = additionalRatings[1];
    return new DishReview(rating, comment, dish,flavorRating,presentationRating);
  }
}
