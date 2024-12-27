package org.example.models;

import org.example.services.interfaces.IObservable;
import org.example.services.interfaces.IObserver;
import org.example.services.interfaces.IReviewable;

import java.util.LinkedList;

public class Dish implements IObservable, IReviewable {
  private String name;
  private Double price;
  private ReviewManager reviewManager;
  private NotificationService notificationService;

  public Dish(String name, Double price) {
    this.name = name;
    this.price = price;
    this.reviewManager = new ReviewManager();
    this.notificationService = new NotificationService();
  }

  public Dish() {
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
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
