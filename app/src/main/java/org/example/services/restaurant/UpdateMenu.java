package org.example.services.restaurant;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UpdateMenu  {
  private IHandler handler;

  public UpdateMenu(IHandler handler) {
    this.handler = handler;
  }

  public UpdateMenu() {
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
}
