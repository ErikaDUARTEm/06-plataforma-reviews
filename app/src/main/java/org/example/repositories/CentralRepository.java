package org.example.repositories;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.models.Review;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CentralRepository {
  private static CentralRepository instance;

  private List<Restaurant> restaurants;
  private LinkedList<Menu> menus;
  private Set<Dish> dishes;
  private List<Review> reviews;

  private CentralRepository(){
   this.restaurants = new ArrayList<>();
   this.menus = new LinkedList<>();
   this.dishes = new HashSet<>();
   this.reviews = new ArrayList<>();
  }
  public static synchronized CentralRepository getInstance(){
    if(instance == null){
      instance = new CentralRepository();
    }
    return instance;
  }
  public void addRestaurant(Restaurant restaurant){
    restaurants.add(restaurant);
  }
  public void addDish(Dish dish){
    dishes.add(dish);
  }
  public void addMenu(){
    for(Restaurant restaurant : restaurants){
      menus.add(restaurant.getMenu());
    }
  }
  public List<Restaurant> getRestaurants(){
    return restaurants;
  }

  public void updateAddress(Restaurant restaurant, Restaurant updateRestaurant){
    if(updateRestaurant.getAddress() != null){
      restaurant.setAddress(updateRestaurant.getAddress());
    }
  }

  public void updateRestaurant(Restaurant updatedRestaurant) {
    for (Restaurant restaurant : restaurants) {
      if (restaurant.getName().equalsIgnoreCase(updatedRestaurant.getName())) {
        updateAddress(restaurant, updatedRestaurant);
        if(updatedRestaurant.getMenu() != null){
           restaurant.setMenu(updatedRestaurant.getMenu());
        }
        return;
      }
    }
    System.out.println("Restaurante no encontrado para actualizar.");
  }
  public void deleteRestaurant(Restaurant restaurant){
    restaurants.remove(restaurant);
  }

}
