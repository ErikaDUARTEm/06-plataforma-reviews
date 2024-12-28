package org.example.services.restaurant;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

import java.util.HashSet;
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
    Set<Dish> listDish = new HashSet<>();
    while (true) {
      handler.writeLine("Ingresa el nombre del plato (o presiona Enter para finalizar)");
      String dishName = handler.readLine();
      if (dishName.isEmpty()) { break; }
      handler.writeLine("Ingresa el precio del plato");
      double dishPrice = Double.parseDouble(handler.readLine());
      listDish.add(new Dish(dishName, dishPrice));
    }
    Menu menu = listDish.isEmpty() ? new Menu() : new Menu(listDish);
    return addRestaurant(nameRestaurant, addressRestaurant, menu);
  }

  public Restaurant addRestaurant(String name, String address, Menu menu){
    Restaurant restaurant = new Restaurant(name, address, menu);
    repository.addRestaurant(restaurant);
    return restaurant;
  }

}