package org.example.services.restaurant;

import org.example.models.MenuRestaurant;
import org.example.models.Restaurant;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

public class UpdateRestaurant implements ICommand<Restaurant> {
  private final CentralRepository repository;
  private final IHandler handler;
  private final UpdateMenu updateMenu;

  public UpdateRestaurant(CentralRepository repository, IHandler handler) {
    this.repository = repository;
    this.handler = handler;
    this.updateMenu = new UpdateMenu(handler, repository);
  }

  @Override
  public Restaurant execute() {
    String nameRestaurant = promptUser("Ingresa el nombre del restaurante");
    String addressRestaurant = promptUser("Ingresa la nueva dirección del restaurante");
    String newNameRestaurant = promptUser("Ingresa el nuevo nombre del restaurante (o presiona Enter para mantener el actual)");

    Restaurant existingRestaurant = repository.findRestaurantByName(nameRestaurant);
    if (existingRestaurant == null) {
      handler.writeLine("Restaurante no encontrado.");
      return null;
    }

    MenuRestaurant newMenuRestaurant = updateMenu.updateMenu(existingRestaurant.getMenu());
    updateRestaurantDetails(existingRestaurant, addressRestaurant, newNameRestaurant, newMenuRestaurant);

    handler.writeLine("Restaurante actualizado exitosamente.");
    return existingRestaurant;
  }

  private String promptUser(String message) {
    handler.writeLine(message);
    return handler.readLine();
  }

  private void updateRestaurantDetails(Restaurant restaurant, String newAddress, String newName, MenuRestaurant newMenuRestaurant) {
    updateName(restaurant, newName);
    updateAddress(restaurant, newAddress);
    updateMenu(restaurant, newMenuRestaurant);
    repository.updateRestaurant(restaurant);
  }

  private void updateName(Restaurant restaurant, String newName) {
    if (newName != null && !newName.isEmpty()) {
      restaurant.setName(newName);
    }
  }

  private void updateAddress(Restaurant restaurant, String newAddress) {
    if (newAddress != null && !newAddress.isEmpty()) {
      restaurant.setAddress(newAddress);
    }
  }

  private void updateMenu(Restaurant restaurant, MenuRestaurant newMenuRestaurant) {
    if (newMenuRestaurant != null) {
      restaurant.setMenu(newMenuRestaurant);
    }
  }
}
