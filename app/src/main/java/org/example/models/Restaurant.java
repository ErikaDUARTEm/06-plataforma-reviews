package org.example.models;

public class Restaurant{
  private String name;
  private String address;
  private MenuRestaurant menuRestaurant;


  public Restaurant(String name, String address, MenuRestaurant menuRestaurant) {
    this.name = name;
    this.address = address;
    this.menuRestaurant = menuRestaurant;
  }

  public Restaurant() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public MenuRestaurant getMenu() {
    return menuRestaurant;
  }

  public void setMenu(MenuRestaurant menuRestaurant) {
    this.menuRestaurant = menuRestaurant;
  }

}
