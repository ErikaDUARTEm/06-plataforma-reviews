package org.example.models;

import java.util.HashSet;
import java.util.Set;

public class MenuRestaurant {
  private Set<Dish> dishes = new HashSet<>();

  public MenuRestaurant(Set<Dish> dishes) {
    this.dishes = dishes;
  }

  public MenuRestaurant() {
  }

  public Set<Dish> getDishes() {
    return dishes;
  }

  public void setDishes(Set<Dish> dishes) {
    this.dishes = dishes;
  }

}
