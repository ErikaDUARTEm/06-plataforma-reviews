package org.example.models;

import java.util.HashSet;
import java.util.Set;

public class Menu {
  private Set<Dish> dishes = new HashSet<>();

  public Menu(Set<Dish> dishes) {
    this.dishes = dishes;
  }
  public Menu() {
  }
  public Set<Dish> getDishes() {
    return dishes;
  }
  public void setDishes(Set<Dish> dishes) {
    this.dishes = dishes;
  }
  public void updateDish(String name, String newName, Double newPrice) {
    dishes.stream()
      .filter(dish -> dish.getName().equalsIgnoreCase(name))
      .findFirst()
      .ifPresentOrElse(dish -> {
        if (newName != null && !newName.isEmpty()) {
          dish.setName(newName);
        }
        if (newPrice != null) {
          dish.setPrice(newPrice);
        }
      }, () -> System.out.println("Plato no encontrado para actualizar."));
   }
}
