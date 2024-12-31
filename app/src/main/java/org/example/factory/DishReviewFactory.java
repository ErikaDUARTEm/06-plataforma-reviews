package org.example.factory;

import org.example.models.Dish;
import org.example.models.reviews.DishReview;
import org.example.models.reviews.Review;

public class DishReviewFactory implements IReviewFactory<Dish>{

  @Override
  public Review createReview(Double rating, String comment, Dish dish, Double... additionalRatings) {
    if(additionalRatings.length < 2){
      throw new IllegalArgumentException("Faltan calificaciones adicionales");
    }
    Double flavorRating = additionalRatings[0];
    Double presentationRating = additionalRatings[1];
    return new DishReview(rating, comment, dish,flavorRating,presentationRating);
  }
}
