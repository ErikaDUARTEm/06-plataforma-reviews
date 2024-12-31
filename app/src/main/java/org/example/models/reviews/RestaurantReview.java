package org.example.models.reviews;

import org.example.models.Restaurant;

public class RestaurantReview extends Review {
  private Restaurant restaurant;
  private Double serviceRating;
  private Double establishmentRating;
  private Double menuRating;

  public RestaurantReview(Double rating, String comment, Restaurant restaurant, Double serviceRating, Double establishmentRating, Double menuRating) {
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

  public Double getServiceRating() {
    return serviceRating;
  }

  public Double getestablishmentRating() {
    return establishmentRating;
  }

  public Double getMenuRating() {
    return menuRating;
  }

}
