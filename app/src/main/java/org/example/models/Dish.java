package org.example.models;

import org.example.services.interfaces.IObservable;
import org.example.services.interfaces.IObserver;


public class Dish{
  private String name;
  private Double price;
  private NotificationService notificationService;

  public Dish(String name, Double price) {
    this.name = name;
    this.price = price;
    this.notificationService = new NotificationService();
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

  public NotificationService getNotificationService() {
    return notificationService;
  }

  public void setNotificationService(NotificationService notificationService) {
    this.notificationService = notificationService;
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
