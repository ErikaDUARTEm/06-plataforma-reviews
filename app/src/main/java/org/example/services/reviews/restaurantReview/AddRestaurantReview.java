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
      int rating = getValidRating();

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
    private int getValidRating () {
      int rating = 0;
      while (true) {
        handler.writeLine("Ingresa la calificacion (1- 5):");
        rating = Integer.parseInt(handler.readLine());
        if (rating >= 1 && rating <= 5) {
          break;
        } else {
          handler.writeLine("Calificación inválida. Por favor ingresa un número entre 1 y 5.");
        }
      }
      return rating;
    }

}