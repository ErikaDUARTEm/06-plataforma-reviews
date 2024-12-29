package org.example.services.restaurant;

import org.example.models.Dish;
import org.example.models.Restaurant;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;
import java.util.List;

public class ShowRestaurants implements ICommand<List<Restaurant>>{

  private final CentralRepository repository;
  private final IHandler handler;

  public ShowRestaurants(IHandler handler, CentralRepository repository){
    this.handler = handler;
    this.repository = repository;
  }

  @Override
  public List<Restaurant> execute() {
        return listRestaurants();
  }

  public List<Restaurant> listRestaurants() {
    List<Restaurant> restaurants = repository.getRestaurants();
    if (restaurants != null && !restaurants.isEmpty()) {
      for (Restaurant restaurant : restaurants) {
        processRestaurantDetails(restaurant);
      }
    } else {
      handler.writeLine("No se encontraron restaurantes guardados en la base de datos.");
    }
    return restaurants;
  }

  private void processRestaurantDetails(Restaurant restaurant) {
    getDetailsRestaurant(restaurant);

    if (restaurant.getMenu() != null) {
       processMenuDetails(restaurant);
    } else {
      handler.writeLine("Menu no disponible en este momento.");
    }
  }

  private void processMenuDetails(Restaurant restaurant){
    for (Dish dish : restaurant.getMenu().getDishes()) {
      getDetailsDish(dish);
    }
  }


  public void getDetailsRestaurant(Restaurant restaurant){
    handler.writeLine("---------------------------------------");
    handler.writeLine("Nombre del restaurante: " + restaurant.getName() +
      "| Direcciòn: " + restaurant.getAddress() +
      "\n Rating: " + repository.calculateRatingAverageRestaurantReviews(restaurant) +
      "\n  Menu: ");
  }
  public void getDetailsDish(Dish dish){
    handler.writeLine(" - Plato: " + dish.getName() + ", Precio: " + dish.getPrice() + "| Rating: " + repository.calculateRatingAverageDishReviews(dish));

  }
}
