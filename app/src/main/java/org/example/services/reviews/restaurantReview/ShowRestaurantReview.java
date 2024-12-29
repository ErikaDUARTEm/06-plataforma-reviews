package org.example.services.reviews.restaurantReview;

import org.example.models.Restaurant;
import org.example.models.reviews.RestaurantReview;
import org.example.models.reviews.Review;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;
import java.util.List;

public class ShowRestaurantReview  implements ICommand<List<RestaurantReview>>{
  private final CentralRepository repository;
  private final IHandler handler;

  public ShowRestaurantReview(CentralRepository repository, IHandler handler) {
    this.repository = repository;
    this.handler = handler;
  }

  @Override
  public List<RestaurantReview> execute() {
    handler.writeLine("Ingresa el nombre del restaurante:");
    String restaurantName = handler.readLine();
    Restaurant restaurant = repository.findRestaurantByName(restaurantName);
    return showRestaurantReview(restaurant);
  }
  public List<RestaurantReview> showRestaurantReview(Restaurant restaurant){
    List<RestaurantReview> listReviews = repository.getReviewByRestaurant(restaurant);
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
