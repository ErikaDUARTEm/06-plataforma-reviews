package org.example.services.reviews.restaurantReview;

import org.example.factory.IReviewFactory;
import org.example.models.NotificationService;
import org.example.models.Restaurant;
import org.example.models.reviews.RestaurantReview;
import org.example.models.reviews.Review;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;


public class AddRestaurantReview implements ICommand<Review> {
  private final CentralRepository repository;
  private final IHandler handler;
  private IReviewFactory<Restaurant> restaurantReviewFactory;
  private NotificationService notificationService;

  public AddRestaurantReview(CentralRepository repository, IHandler handler, IReviewFactory<Restaurant> restaurantReviewFactory, NotificationService notificationService) {
    this.repository = repository;
    this.handler = handler;
    this.restaurantReviewFactory = restaurantReviewFactory;
    this.notificationService = notificationService;
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
      int rating = getValidRating(handler, "General");
      int serviceRating = getValidRating(handler, "Servicie");
      int establishmentRating = getValidRating(handler, "Establishment");
      int menuRating = getValidRating(handler, "Menu");


      handler.writeLine("Ingresa un comentario: ");
      String comment = handler.readLine();

      Review review = restaurantReviewFactory.createReview( rating, comment, restaurant, serviceRating, establishmentRating, menuRating);
      repository.addRestaurantReview((RestaurantReview) review);
      notificationService.notifyNewReview(restaurantName, "Restaurante", rating);
      Double averageRating = repository.calculateRatingAverageRestaurantReviews(restaurant);
      repository.notifyRatingChangeRestaurant(restaurant, averageRating);
      handler.writeLine("Review agregada exitosamente.");
      return review;
    } else {
      handler.writeLine("Restaurante no encontrado.");
      return null;
    }
}
    private Integer getValidRating (IHandler handler, String type) {
      int rating = 0;
      while (true) {
        handler.writeLine("Ingresa la calificación para " + type + " (1-5):");
        try{
          rating = Integer.parseInt(handler.readLine());
          if (rating >= 1 && rating <= 5) {
            break;
          } else {
            handler.writeLine("Calificación inválida. Por favor ingresa un número entre 1 y 5.");
          }
        }catch (NumberFormatException e){
          handler.writeLine("Por favor, ingresa un número válido.");
        }
      }
      return rating;
    }

}