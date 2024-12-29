package org.example.services.reviews.dishReview;

import org.example.factory.IReviewFactory;
import org.example.models.Dish;
import org.example.models.reviews.DishReview;
import org.example.models.NotificationService;
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
    handler.writeLine("Ingresa el nombre del restaurante:");
    String restaurantName = handler.readLine();
    Restaurant restaurant = repository.findRestaurantByName(restaurantName);
    if (restaurant != null) {
      handler.writeLine("Ingresa el nombre del plato: ");
      String nameDish = handler.readLine();
      Dish dish = repository.findDishByName(nameDish);
      if (dish != null) {
        int rating = getValidRating(handler, "General");
        Integer flavorRating = getValidRating(handler, "Sabor");
        Integer presentationRating = getValidRating( handler, "Presentación");

        handler.writeLine("Ingresa un comentario: ");
        String comment = handler.readLine();
        Review review = dishReviewFactory.createReview(rating, comment, dish, flavorRating, presentationRating);

        repository.addDishReview((DishReview) review);
        notificationService.notifyNewReview(nameDish, "Plato", rating);
        Double averageRating = repository.calculateRatingAverageDishReviews(dish);
        repository.notifyRatingChangeDish(dish, averageRating);
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

  private Integer getValidRating(IHandler handler, String type) {
    int rating = 0;
    while (true) {
      handler.writeLine("Ingresa la calificación para " + type + " (1-5):");
      try {
        rating = Integer.parseInt(handler.readLine());
        if (rating >= 1 && rating <= 5) {
          break;
        } else {
          handler.writeLine("Calificación inválida. Por favor ingresa un número entre 1 y 5.");
        }
      } catch (NumberFormatException e) {
        handler.writeLine("Por favor, ingresa un número válido.");
      }
    }
    return rating;
  }
}
