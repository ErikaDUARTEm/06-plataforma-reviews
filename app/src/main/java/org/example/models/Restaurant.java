package org.example.models;

public class Restaurant{
  private String name;
  private String address;
  private Menu menu;


  public Restaurant(String name, String address, Menu menu) {
    this.name = name;
    this.address = address;
    this.menu = menu;
  }

  private Restaurant() {
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

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

}
