package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

public class AddRestaurant implements ICommand<Restaurant> {
  private final CentralRepository repository;
  private final IHandler handler;

  public AddRestaurant(CentralRepository repository, IHandler handler) {
    this.repository = repository;
    this.handler = handler;
  }


  @Override
  public Restaurant execute() {
    handler.writeLine("Ingresa el nombre del restaurante");
    String nameRestaurant = handler.readLine();
    handler.writeLine("Ingresa la dirección del restaurante");
    String addressRestaurant = handler.readLine();
    return addRestaurant(nameRestaurant, addressRestaurant);
  }

  public Restaurant addRestaurant(String name, String address){
    Restaurant restaurant = new Restaurant(name, address);
    repository.addRestaurant(restaurant);
    return restaurant;
  }
}
