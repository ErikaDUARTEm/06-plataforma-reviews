package org.example.services.reviews.restaurantReview;

import org.example.factory.IReviewFactory;
import org.example.models.Restaurant;
import org.example.models.RestaurantReview;
import org.example.models.Review;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;


public class AddRestaurantReview implements ICommand<Review> {
  private final CentralRepository repository;
  private final IHandler handler;
  private IReviewFactory<Restaurant> restaurantReviewFactory;


  public AddRestaurantReview(CentralRepository repository, IHandler handler, IReviewFactory<Restaurant> restaurantReviewFactory) {
    this.repository = repository;
    this.handler = handler;
    this.restaurantReviewFactory = restaurantReviewFactory;
  }

  @Override
  public Review execute() {
     return addReview();
  }

  public Review addReview() {
    handler.writeLine("Ingresa el nombre del restaurante:");
    String restaurantName = handler.readLine();
    Restaurant restaurant = repository.findRestaurantByName(restaurantName);
    if (restaurant != null) {
      handler.writeLine("Ingresa la calificacion (1- 5):");
      int rating = Integer.parseInt(handler.readLine());
      handler.writeLine("Ingresa un comentario: ");
      String comment = handler.readLine();

      Review review = restaurantReviewFactory.createReview(rating, comment, restaurant);
      repository.addRestaurantReview((RestaurantReview) review);
      handler.writeLine("Review agregada exitosamente.");
      return review;
    } else {
      handler.writeLine("Restaurante no encontrado.");
      return null;
    }
  }
}