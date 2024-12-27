package org.example.models;

public class RestaurantReview extends Review{
  private Restaurant restaurant;
  private Integer service;
  private Integer establishment;
  private Integer menu;


  public RestaurantReview(Integer rating, String comment, Restaurant restaurant, Integer service, Integer establishment, Integer menu) {
    super(rating, comment);
    this.restaurant = restaurant;
    this.service = service;
    this.establishment = establishment;
    this.menu = menu;
  }
  public RestaurantReview(){};

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public Integer getService() {
    return service;
  }

  public void setService(Integer service) {
    this.service = service;
  }

  public Integer getEstablishment() {
    return establishment;
  }

  public void setEstablishment(Integer establishment) {
    this.establishment = establishment;
  }

  public Integer getMenu() {
    return menu;
  }

  public void setMenu(Integer menu) {
    this.menu = menu;
  }

}
