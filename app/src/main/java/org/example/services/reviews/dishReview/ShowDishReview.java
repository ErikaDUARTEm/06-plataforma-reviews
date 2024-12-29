package org.example.services.reviews.dishReview;

import org.example.models.Dish;
import org.example.models.reviews.DishReview;
import org.example.models.Restaurant;
import org.example.models.reviews.Review;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;
import java.util.List;

public class ShowDishReview implements ICommand {

  private final CentralRepository repository;
  private final IHandler handler;

  public ShowDishReview(CentralRepository repository, IHandler handler) {
    this.repository = repository;
    this.handler = handler;
  }

  @Override
  public List<DishReview> execute() {
    handler.writeLine("Ingresa el nombre del restaurante:");
    String restaurantName = handler.readLine();
    Restaurant restaurant = repository.findRestaurantByName(restaurantName);
    if (restaurant != null) {
      handler.writeLine("Ingresa el nombre del plato:");
      String dishName = handler.readLine();
      Dish dish = repository.findDishByName(dishName);
      return showDishReview(dish);
    } else {
      handler.writeLine("Restaurante no encontrado.");
    }
   return null;
}

  public List<DishReview> showDishReview(Dish dish){
    List<DishReview> listReviews = repository.getReviewByDish(dish);
    if(listReviews != null && !listReviews.isEmpty()){
      for(Review review : listReviews ){
        handler.writeLine(review.getDetails());
      }
    }else{
      handler.writeLine("No se encontraron reviews.");
    }
    return listReviews;
  }

}
