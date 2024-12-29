package org.example.services.restaurant;

import org.example.models.Dish;
import org.example.repositories.CentralRepository;
import org.example.utils.IHandler;

import java.util.HashSet;
import java.util.Set;

public class AddDish {
  private IHandler handler;
  private CentralRepository repository;

  public AddDish(IHandler handler, CentralRepository repository) {
    this.handler = handler;
    this.repository = repository;
  }

  private AddDish() {
  }

  public Set<Dish> createDish(){
    Set<Dish> listDish = new HashSet<>();
    while (true) {
      handler.writeLine("Ingresa el nombre del plato (o presiona Enter para finalizar)");
      String dishName = handler.readLine();
      if (dishName.isEmpty()) { break; }
      handler.writeLine("Ingresa el precio del plato");
      double dishPrice = Double.parseDouble(handler.readLine());
      Dish dish = new Dish(dishName, dishPrice);
      listDish.add(dish);
      repository.addDish(dish);
    }
    return listDish;
  }

}
