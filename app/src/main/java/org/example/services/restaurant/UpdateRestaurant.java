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

  public UpdateRestaurant(CentralRepository repository, IHandler handler) {
    this.repository = repository;
    this.handler = handler;
  }

  @Override
  public Restaurant execute() {
    handler.writeLine("Ingresa el nombre del restaurante");
    String nameRestaurant = handler.readLine();
    handler.writeLine("Ingresa la nueva dirección del restaurante");
    String addressRestaurant = handler.readLine();
    handler.writeLine("Ingresa el nuevo nombre del restaurante (o presiona Enter para mantener el actual)");
    String newNameRestaurant = handler.readLine();

    Restaurant existingRestaurant = findRestaurantByName(nameRestaurant);

    Menu menu = updateMenu(existingRestaurant.getMenu());
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

  public Menu updateMenu(Menu existingMenu) {
    Set<Dish> listDish = new HashSet<>(existingMenu.getDishes());
    while (true) {
      handler.writeLine("Ingresa el nombre del nuevo o existente plato (o presiona Enter para finalizar)");
      String dishName = handler.readLine();
      if (dishName.isEmpty()) {
        break;
      }
      handler.writeLine("Ingresa el nuevo nombre del plato (o presiona Enter para mantener el actual)");
      String newDishName = handler.readLine();
      handler.writeLine("Ingresa el precio del plato");
      double dishPrice = Double.parseDouble(handler.readLine());

      Optional<Dish> optionalDish = listDish.stream()
        .filter(dish -> dish.getName().equalsIgnoreCase(dishName))
        .findFirst();

      if (optionalDish.isPresent()) {
        existingMenu.updateDish(dishName, newDishName, dishPrice);
      } else {
        listDish.add(new Dish(newDishName.isEmpty() ? dishName : newDishName, dishPrice));
      }
    }
    existingMenu.setDishes(listDish);
    return existingMenu;
  }

  private Restaurant findRestaurantByName(String nameRestaurant) {
    return repository.getRestaurants().stream()
      .filter(restaurant -> restaurant.getName().equalsIgnoreCase(nameRestaurant))
      .findFirst()
      .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
  }
}
