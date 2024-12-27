package org.example.repositories;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.models.Review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CentralRepository {
  private static CentralRepository instance;

  private List<Restaurant> restaurants;
  private LinkedList<Menu> menus;
  private List<Dish> dishes;
  private List<Review> reviews;

  private CentralRepository(){
   this.restaurants = new ArrayList<>();
   this.menus = new LinkedList<>();
   this.dishes = new ArrayList<>();
   this.reviews = new ArrayList<>();
  }
  public static synchronized CentralRepository getInstance(){
    if(instance == null){
      instance = new CentralRepository();
    }
    return instance;
  }
  
}
