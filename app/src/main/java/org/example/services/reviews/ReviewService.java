package org.example.services.reviews;

import org.example.factory.DishReviewFactory;
import org.example.factory.IReviewFactory;
import org.example.factory.RestaurantReviewFactory;
import org.example.models.Dish;
import org.example.models.Restaurant;
import org.example.models.Review;
import org.example.repositories.CentralRepository;

public class ReviewService {
  private CentralRepository repository;
  private IReviewFactory<Restaurant> restaurantReviewFactory;
  private IReviewFactory<Dish> dishReviewFactory;


  public ReviewService() {
    this.repository = CentralRepository.getInstance();
    this.restaurantReviewFactory = new RestaurantReviewFactory();
    this.dishReviewFactory = new DishReviewFactory();
  }
  public Review createRestaurantReview(int rating, String comment, Restaurant restaurant) {
    return restaurantReviewFactory.createReview(rating, comment, restaurant);
  }
  public Review createDishReview(int rating, String comment, Dish dish) {
    return dishReviewFactory.createReview(rating, comment, dish);
  }
}
