package org.example.factory;

import org.example.models.Restaurant;
import org.example.models.reviews.RestaurantReview;
import org.example.models.reviews.Review;

public class RestaurantReviewFactory implements IReviewFactory<Restaurant> {

  @Override
  public Review createReview(int rating, String comment, Restaurant restaurant, Integer... additionalRatings) {
    if (additionalRatings.length < 3) {
      throw new IllegalArgumentException("Faltan calificaciones adicionales para el restaurante.");
    }
    Integer serviceRating = additionalRatings[0];
    Integer establishmentRating = additionalRatings[1];
    Integer menuRating = additionalRatings[2];
    return new RestaurantReview(rating, comment, restaurant, serviceRating, establishmentRating, menuRating);
  }
}
