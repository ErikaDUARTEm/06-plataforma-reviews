package org.example.models;

import org.example.services.interfaces.IObservable;
import org.example.services.interfaces.IObserver;


public class Restaurant implements IObservable {
  private String name;
  private String address;
  private Menu menu;
  private NotificationService notificationService;


  public Restaurant(String name, String address, Menu menu) {
    this.name = name;
    this.address = address;
    this.menu = menu;
    this.notificationService = new NotificationService();
  }

  public Restaurant() {
  }

  @Override
  public void addObserver(IObserver observer) {

  }

  @Override
  public void removeObserve(IObserver observer) {

  }

  @Override
  public void notifyObservers(String message) {

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

  public NotificationService getNotificationService() {
    return notificationService;
  }

  public void setNotificationService(NotificationService notificationService) {
    this.notificationService = notificationService;
  }
}
