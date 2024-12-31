package org.example.factory;

import org.example.models.Restaurant;
import org.example.models.reviews.RestaurantReview;
import org.example.models.reviews.Review;

public class RestaurantReviewFactory implements IReviewFactory<Restaurant> {

  @Override
  public Review createReview(Double rating, String comment, Restaurant restaurant, Double... additionalRatings) {
    if (additionalRatings.length < 3) {
      throw new IllegalArgumentException("Faltan calificaciones adicionales para el restaurante.");
    }
    Double serviceRating = additionalRatings[0];
    Double establishmentRating = additionalRatings[1];
    Double menuRating = additionalRatings[2];
    return new RestaurantReview(rating, comment, restaurant, serviceRating, establishmentRating, menuRating);
  }
}
