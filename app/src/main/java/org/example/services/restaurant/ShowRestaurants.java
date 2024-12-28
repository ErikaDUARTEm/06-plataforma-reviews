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
    if(restaurants != null && !restaurants.isEmpty()) {
      for (Restaurant restaurant : restaurants) {
        handler.writeLine("Nombre del restaurante: " + restaurant.getName() +
          " | Direcciòn: " + restaurant.getAddress() +
          "\n  Menu: ");
        if (restaurant.getMenu() != null) {
          for (Dish dish : restaurant.getMenu().getDishes()) {
            handler.writeLine(" - Plato: " + dish.getName() + ", Precio: " + dish.getPrice());
          }
        } else {
          handler.writeLine("Menu no disponible en este momento.");
        }
      }
    }else{
      handler.writeLine("No se encontraron restaurantes guardados en la base de datos.");
    }
    return restaurants;
  }
}
