package org.example.services.restaurant;

import org.example.models.Dish;
import org.example.models.MenuRestaurant;
import org.example.repositories.CentralRepository;
import org.example.utils.IHandler;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UpdateMenu {
  private IHandler handler;
  private CentralRepository repository;

  public UpdateMenu(IHandler handler, CentralRepository repository) {
    this.handler = handler;
    this.repository = repository;
  }

  private UpdateMenu() {
  }

  public MenuRestaurant updateMenu(MenuRestaurant existingMenuRestaurant) {
    Set<Dish> listDish = new HashSet<>(existingMenuRestaurant.getDishes());
    while (true) {
      handler.writeLine("Ingresa el nombre del plato nuevo o existente (o presiona doble Enter para finalizar)");
      String dishName = handler.readLine();
      if (dishName.isEmpty()) {
        break;
      }
      handler.writeLine("¿Quieres agregar, editar o eliminar un plato? escribe una opcion: (agregar / editar / eliminar)");
      String action = handler.readLine();
      handleDish(action, dishName, listDish);
    }
    existingMenuRestaurant.setDishes(listDish);
    return existingMenuRestaurant;
  }

  private void handleDish(String action, String dishName, Set<Dish> listDish) {
    Optional<Dish> optionalDish = listDish.stream()
      .filter(dish -> dish.getName().equalsIgnoreCase(dishName))
      .findFirst();

    if (action.equalsIgnoreCase("eliminar")) {
      deleteDish(dishName, optionalDish, listDish);
    } else if (action.equalsIgnoreCase("editar")) {
      if (optionalDish.isPresent()) {
        editDish(dishName, optionalDish.get());
      } else {
        addNewDish(dishName, listDish);
      }
    } else if (action.equalsIgnoreCase("agregar")) {
      addNewDishDirectly(listDish);
    } else {
      handler.writeLine("Acción no válida. Por favor, escribe 'editar', 'eliminar' o 'agregar'.");
    }
  }

  private void editDish(String dishName, Dish dish){
    handler.writeLine("Ingresa el nuevo nombre del plato (o presiona enter para mantener el actual)");
    String newDishName = handler.readLine();
    handler.writeLine("Ingresa el precio del plato");
    Double dishPrice = getValidPrice();

    dish.setName(newDishName.isEmpty() ? dishName : newDishName);
    dish.setPrice(dishPrice);
    handler.writeLine("Plato editado exitosamente.");
  }
  private void addNewDish(String dishName, Set<Dish> listDish){
    handler.writeLine("El plato no se encontro para editar. Se agregara como un nuevo plato.");
    handler.writeLine("Ingresa el nuevo nombre del plato (0 presiona enter para mantener el mismo.)");
    String newDishName = handler.readLine();
    handler.writeLine("Ingresa el precio del plato");
    Double dishPrice = Double.parseDouble(handler.readLine());
    listDish.add(new Dish(newDishName.isEmpty() ? dishName : newDishName, dishPrice));
  }
  private String getDishName() {
    String dishName;
    do {
      handler.writeLine("Ingresa el nombre del nuevo plato:");
      dishName = handler.readLine();
      if (dishName == null || dishName.trim().isEmpty()) {
        handler.writeLine("El nombre del plato no puede estar vacío. Inténtalo de nuevo.");
      }
    } while (dishName == null || dishName.trim().isEmpty());
    return dishName;
  }

  private Double getDishPrice() {
    Double dishPrice = null;
    while (dishPrice == null) {
      handler.writeLine("Ingresa el precio del plato:");
      try {
        dishPrice = Double.parseDouble(handler.readLine());
      } catch (NumberFormatException e) {
        handler.writeLine("Precio inválido. Por favor, introduce un número válido.");
      }
    }
    return dishPrice;
  }

  private void addDishToList(String dishName, Double dishPrice, Set<Dish> listDish) {
    listDish.add(new Dish(dishName, dishPrice));
    handler.writeLine("Plato agregado exitosamente.");
  }
  private void addNewDishDirectly(Set<Dish> listDish) {
    String dishName = getDishName();
    Double dishPrice = getDishPrice();
    addDishToList(dishName, dishPrice, listDish);
  }
  private void deleteDish(String dishName, Optional<Dish> optionalDish, Set<Dish> listDish) {
    if (optionalDish.isPresent()) {
      listDish.remove(optionalDish.get());
      repository.deleteDish(dishName);
      handler.writeLine("Plato eliminado exitosamente.");
    } else {
      handler.writeLine("El plato no se encontro.");
    }
  }
  private Double getValidPrice(){
    double dishPrice;
    while(true){
      try{
        dishPrice = Double.parseDouble(handler.readLine());
        break;
      }catch (NumberFormatException e){
        handler.writeLine("Precio invalido. por favor ingresa un numero valido.");
      }
    }
    return dishPrice;
  }
}