package org.example.factory;

import org.example.models.Restaurant;
import org.example.models.reviews.RestaurantReview;
import org.example.models.reviews.Review;

public class RestaurantReviewFactory implements IReviewFactory<Restaurant> {

  @Override
  public Review createReview(int rating, String comment, Restaurant restaurant) {
    return new RestaurantReview(rating, comment, restaurant, 5, 4, 5);
  }
}
