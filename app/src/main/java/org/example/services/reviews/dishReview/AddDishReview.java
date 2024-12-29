package org.example.services.reviews.dishReview;

import org.example.factory.IReviewFactory;
import org.example.models.Dish;
import org.example.models.DishReview;
import org.example.models.Restaurant;
import org.example.models.Review;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

public class AddDishReview implements ICommand {
  private final CentralRepository repository;
  private final IHandler handler;
  private final IReviewFactory<Dish> dishReviewFactory;

  public AddDishReview(CentralRepository repository, IHandler handler, IReviewFactory<Dish> dishReviewFactory) {
    this.repository = repository;
    this.handler = handler;
    this.dishReviewFactory = dishReviewFactory;
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
      if (dish != null){
        int rating = getValidRating();
        handler.writeLine("Ingresa un comentario: ");
        String comment = handler.readLine();

        Review review = dishReviewFactory.createReview(rating, comment, dish);

        repository.addDishReview((DishReview) review);
        handler.writeLine("Review agregada exitosamente.");
        return review;
      }else
      { handler.writeLine("Plato no encontrado.");}
    } else {
      handler.writeLine("Restaurante no encontrado.");
    }
    return null;
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
