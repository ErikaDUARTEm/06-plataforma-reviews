package org.example.services.restaurant;

import org.example.models.Dish;
import org.example.models.MenuRestaurant;
import org.example.models.Restaurant;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;
import java.util.Set;

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

    AddDish addDish = new AddDish(handler, repository);
    Set<Dish> listDish = addDish.createDish();

    MenuRestaurant menuRestaurant = listDish.isEmpty() ? new MenuRestaurant() : new MenuRestaurant(listDish);
    return addRestaurant(nameRestaurant, addressRestaurant, menuRestaurant);
  }

  public Restaurant addRestaurant(String name, String address, MenuRestaurant menuRestaurant){
    Restaurant restaurant = new Restaurant(name, address, menuRestaurant);
    repository.addRestaurant(restaurant);
    repository.addMenu();
    return restaurant;
  }

}