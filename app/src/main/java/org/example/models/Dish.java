package org.example.models;

public class Dish{
  private String name;
  private Double price;

  public Dish(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public Dish() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Dish{");
    sb.append("name='").append(name).append('\'');
    sb.append(", price=").append(price);
    sb.append('}');
    return sb.toString();
  }

}
