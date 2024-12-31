package org.example.repositories;

import org.example.models.Dish;
import org.example.models.reviews.DishReview;
import org.example.models.MenuRestaurant;
import org.example.utils.NotificationService;
import org.example.models.Restaurant;
import org.example.models.reviews.RestaurantReview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CentralRepository {
  private static CentralRepository instance;
  private NotificationService notificationService;
  private List<Restaurant> restaurants;
  private LinkedList<MenuRestaurant> menuRestaurants;
  private Set<Dish> dishes;
  private List<RestaurantReview> restaurantReviews;
  private List<DishReview> dishReviews;

  private CentralRepository(NotificationService notificationService){
    this.notificationService = notificationService;
    this.restaurants = new ArrayList<>();
    this.menuRestaurants = new LinkedList<>();
    this.dishes = new HashSet<>();
    this.restaurantReviews = new ArrayList<>();
    this.dishReviews = new ArrayList<>();
  }
  public static synchronized CentralRepository getInstance(NotificationService notificationService){
    if(instance == null){
      instance = new CentralRepository(notificationService);
    }
    return instance;
  }

  public void addRestaurant(Restaurant restaurant){
    restaurants.add(restaurant);
  }
  public void addDish(Dish dish){
    dishes.add(dish);
  }
  public Set<Dish> getDish(){
    return dishes;
  }

  public void addMenu(){
    menuRestaurants.clear();
    for(Restaurant restaurant : restaurants){
      menuRestaurants.add(restaurant.getMenu());
    }
  }
  public void deleteDish(String nameDish){
    dishes.remove(nameDish);
  }
  public List<Restaurant> getRestaurants(){
    return restaurants;
  }
  public Restaurant findRestaurantByName(String nameRestaurant) {
    return getRestaurants().stream()
      .filter(restaurant -> restaurant.getName()!= null && restaurant.getName().equalsIgnoreCase(nameRestaurant))
      .findFirst()
      .orElse(null);
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

  public void addRestaurantReview(RestaurantReview review){
    restaurantReviews.add(review);
  }
  public List<RestaurantReview> getReviewByRestaurant(Restaurant restaurant){
    List<RestaurantReview> reviews = new ArrayList<>();
    for(RestaurantReview review : restaurantReviews){
      if (review.getRestaurant().equals(restaurant)){
        reviews.add(review);
      }
    }
    return reviews;
  }
  public Double calculateRatingAverageRestaurantReviews(Restaurant restaurant){
    List<RestaurantReview> reviews = getReviewByRestaurant(restaurant);
     return reviews.stream()
       .mapToDouble(review ->(review.getRating() +
                              review.getServiceRating() +
                              review.getestablishmentRating() +
                              review.getMenuRating())/ 4.0)
       .average().orElse(0);
    }

  public Dish findDishByName(String nameDish) {
    return getDish().stream()
      .filter(dish -> dish.getName().equalsIgnoreCase(nameDish.trim()))
      .findFirst()
      .orElse(null);
  }
  public void addDishReview(DishReview review){
    dishReviews.add(review);
  }
  public List<DishReview> getReviewByDish(Dish dish){
    List<DishReview> reviews = new ArrayList<>();
    for(DishReview review : dishReviews){
      if (review.getDish().equals(dish)){
        reviews.add(review);
      }
    }
    return reviews;
  }
  public Double calculateRatingAverageDishReviews(Dish dish){
    List<DishReview> reviews = getReviewByDish(dish);
    return reviews.stream()
      .mapToDouble(review ->(
        review.getRating() +
        review.getFlavorRating() +
        review.getPresentatioNRating())/ 3.0)
      .average().orElse(0);
  }
  public void notifyRatingChangeRestaurant(Restaurant restaurant, Double averageRating){
    notificationService.notifyRatingChange(restaurant.getName(), "Restaurant", averageRating);
  }
  public void notifyRatingChangeDish(Dish dish, Double averageRating){
    notificationService.notifyRatingChange(dish.getName(), "Plato", averageRating);
  }
}
