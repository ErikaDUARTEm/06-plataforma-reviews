package org.example.services.restaurant;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.repositories.CentralRepository;
import org.example.services.interfaces.ICommand;
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

  public UpdateMenu() {
  }

  public Menu updateMenu(Menu existingMenu) {
    Set<Dish> listDish = new HashSet<>(existingMenu.getDishes());
    while (true) {
      handler.writeLine("Ingresa el nombre del plato nuevo o existente (o presiona doble Enter para finalizar)");
      String dishName = handler.readLine();
      if (dishName.isEmpty()) {
        break;
      }
      handler.writeLine("¿Quieres editar o eliminar un plato? escribe una opcion: (editar / eliminar)");
      String action = handler.readLine();
      handleDish(action, dishName, listDish);
    }
    existingMenu.setDishes(listDish);
    return existingMenu;
  }

  private void handleDish(String action, String dishName, Set<Dish> listDish) {
    Optional<Dish> optionalDish = listDish.stream()
      .filter(dish -> dish.getName().equalsIgnoreCase(dishName))
      .findFirst();

    if (action.equalsIgnoreCase("eliminar")) {
       deleteDish(dishName, optionalDish, listDish);
    } else if (action.equalsIgnoreCase("editar")) {
      if(optionalDish.isPresent()){
        editDish(dishName, optionalDish.get());
      }else{
        addNewDish(dishName, listDish);
      }
    }else{
      handler.writeLine("Accion no valida. por favor, escribe 'editar' o 'eliminar' ");
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