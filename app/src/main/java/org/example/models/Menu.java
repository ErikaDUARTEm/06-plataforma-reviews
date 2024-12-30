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

  public void start() {

  }
}
