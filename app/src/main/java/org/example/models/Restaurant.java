package org.example.models;

import org.example.services.interfaces.IObservable;
import org.example.services.interfaces.IObserver;
import org.example.services.interfaces.IReviewable;

import java.util.LinkedList;

public class Restaurant implements IReviewable {
  private String name;
  private String address;
  private Menu menu;
  private ReviewManager reviewManager;
  private NotificationService notificationService;


  public Restaurant(String name, String address) {
    this.name = name;
    this.address = address;
    this.menu = new Menu();
    this.notificationService = new NotificationService();
  }

  public Restaurant() {
  }

  @Override
  public void addReview(Review review) {

  }

  @Override
  public void calculateAverageRating() {

  }

  @Override
  public Double getAverageRating() {
    return 0.0;
  }

  @Override
  public LinkedList<Review> getReviews() {
    return null;
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

  public ReviewManager getReviewManager() {
    return reviewManager;
  }

  public void setReviewManager(ReviewManager reviewManager) {
    this.reviewManager = reviewManager;
  }

  public NotificationService getNotificationService() {
    return notificationService;
  }

  public void setNotificationService(NotificationService notificationService) {
    this.notificationService = notificationService;
  }
}
