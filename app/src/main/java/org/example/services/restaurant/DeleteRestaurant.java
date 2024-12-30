package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

public class DeleteRestaurant implements ICommand<Restaurant> {
  private CentralRepository repository;
  private IHandler handler;

  public DeleteRestaurant(CentralRepository centralRepository, IHandler handler) {
    this.repository = centralRepository;
    this.handler = handler;
  }

  private DeleteRestaurant() {
  }

  @Override
  public Restaurant execute() {
    handler.writeLine("Ingresa el nombre del restaurante que deseas eliminar.");
    String nameDelete = handler.readLine();
    return deleteRestaurante(nameDelete);
  }
  public Restaurant deleteRestaurante(String nameDelete){
    Restaurant findName = findRestaurantByName(nameDelete);
    repository.deleteRestaurant(findName);
    handler.writeLine("Restaurante eliminado exitosamente.");
    return findName;
  }
  private Restaurant findRestaurantByName(String nameRestaurant) {
    return repository.getRestaurants().stream()
      .filter(restaurant -> restaurant.getName().equalsIgnoreCase(nameRestaurant))
      .findFirst()
      .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
  }

}
