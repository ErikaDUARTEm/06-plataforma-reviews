package org.example.services.restaurant;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UpdateRestaurant implements ICommand<Restaurant> {
  private final CentralRepository repository;
  private final IHandler handler;
  private UpdateMenu updateMenu;

  public UpdateRestaurant(CentralRepository repository, IHandler handler) {
    this.repository = repository;
    this.handler = handler;
    this.updateMenu = new UpdateMenu(handler, repository);
  }

  @Override
  public Restaurant execute() {
    handler.writeLine("Ingresa el nombre del restaurante");
    String nameRestaurant = handler.readLine();
    handler.writeLine("Ingresa la nueva dirección del restaurante");
    String addressRestaurant = handler.readLine();
    handler.writeLine("Ingresa el nuevo nombre del restaurante (o presiona Enter para mantener el actual)");
    String newNameRestaurant = handler.readLine();

    Restaurant existingRestaurant = repository.findRestaurantByName(nameRestaurant);

    Menu menu = updateMenu.updateMenu(existingRestaurant.getMenu());
    updateNameAddressMenuRestaurant(existingRestaurant, addressRestaurant, newNameRestaurant, menu);
    handler.writeLine("Restaurante actualizado exitosamente.");
    existingRestaurant.toString();
    return existingRestaurant;
  }

  public Restaurant updateNameAddressMenuRestaurant(Restaurant restaurant, String newAddress, String newName, Menu newMenu) {
    if (newName != null && !newName.isEmpty()) {
      restaurant.setName(newName);
    }
    if (newAddress != null && !newAddress.isEmpty()) {
      restaurant.setAddress(newAddress);
    }
    if (newMenu != null) {
      restaurant.setMenu(newMenu);
    }
    repository.updateRestaurant(restaurant);
    return restaurant;
  }

}
