package org.example.models.reviews;

import org.example.models.Restaurant;

public class RestaurantReview extends Review {
  private Restaurant restaurant;
  private Integer serviceRating;
  private Integer establishmentRating;
  private Integer menuRating;

  public RestaurantReview(Integer rating, String comment, Restaurant restaurant, Integer serviceRating, Integer establishmentRating, Integer menuRating) {
    super(rating, comment);
    this.restaurant = restaurant;
    this.serviceRating = serviceRating;
    this.establishmentRating = establishmentRating;
    this.menuRating = menuRating;
  }

  @Override public String getDetails() {
    return "Restaurant: \n" + restaurant.getName() + ", \n"+ "Calificación: " + getRating() +
    ", \nComentario: " + getComment();
  }
  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public Integer getServiceRating() {
    return serviceRating;
  }

  public Integer getestablishmentRating() {
    return establishmentRating;
  }

  public Integer getMenuRating() {
    return menuRating;
  }

}
