package org.example.services.reviews.dishReview;

import org.example.factory.IReviewFactory;
import org.example.models.Dish;
import org.example.models.reviews.DishReview;
import org.example.utils.NotificationService;
import org.example.models.Restaurant;
import org.example.models.reviews.Review;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

public class AddDishReview implements ICommand {
  private final CentralRepository repository;
  private final IHandler handler;
  private final IReviewFactory<Dish> dishReviewFactory;
  private final NotificationService notificationService;

  public AddDishReview(CentralRepository repository, IHandler handler, IReviewFactory<Dish> dishReviewFactory, NotificationService notificationService) {
    this.repository = repository;
    this.handler = handler;
    this.dishReviewFactory = dishReviewFactory;
    this.notificationService = notificationService;
  }

  @Override
  public Object execute() {
    return addReview();
  }

  public Review addReview() {
    String restaurantName = promptForInput("Ingresa el nombre del restaurante:");
    Restaurant restaurant = repository.findRestaurantByName(restaurantName);
    if (restaurant != null) {
      String nameDish = promptForInput("Ingresa el nombre del plato:");
      Dish dish = repository.findDishByName(nameDish);
      if (dish != null) {
        int rating = getValidRating("General");
        int flavorRating = getValidRating("Sabor");
        int presentationRating = getValidRating("Presentacion");
        String comment = promptForInput("Ingresa un comentario:");

        Review review = dishReviewFactory.createReview(rating, comment, dish, flavorRating, presentationRating);
        processReview(dish, review, nameDish, rating);

        handler.writeLine("Review agregada exitosamente.");
        return review;
      } else {
        handler.writeLine("Plato no encontrado.");
      }
    } else {
      handler.writeLine("Restaurante no encontrado.");
    }
    return null;
  }

  private String promptForInput(String message) {
    handler.writeLine(message);
    return handler.readLine();
  }

  private int getValidRating(String type) {
    int rating = 0;
    while (true) {
      handler.writeLine("Ingresa la calificacion para " + type + " (1-5):");
      try {
        rating = Integer.parseInt(handler.readLine());
        if (rating >= 1 && rating <= 5) {
          break;
        } else {
          handler.writeLine("Calificacion invalida. Por favor ingresa un numero entre 1 y 5.");
        }
      } catch (NumberFormatException e) {
        handler.writeLine("Por favor, ingresa un numero valido.");
      }
    }
    return rating;
  }

  private void processReview(Dish dish, Review review, String nameDish, int rating) {
    repository.addDishReview((DishReview) review);
    notificationService.notifyNewReview(nameDish, "Plato", rating);
    Double averageRating = repository.calculateRatingAverageDishReviews(dish);
    repository.notifyRatingChangeDish(dish, averageRating);
  }
}
