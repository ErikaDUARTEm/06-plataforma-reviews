package org.example.models;

import org.example.services.interfaces.IObservable;
import org.example.services.interfaces.IObserver;
import java.util.LinkedList;

public class NotificationService implements IObservable {

  private final LinkedList<IObserver> observers;


  public NotificationService() {
    this.observers = new LinkedList<>();
  }

  @Override
  public void addObserver(IObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserve(IObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(String message) {
    for(IObserver observer : observers){
      observer.update(message);
    }
  }
  public void notifyNewReview(String entityName, String entityType, Integer rating){
    String message = "Nueva review añadida para " + entityType + ": " + entityName + ". con una calificación: " + rating;
    notifyObservers(message);
  }
  public void notifyRatingChange(String entityName, String entityType, Double avegareRating){
    String message = "Calificación promedio actualizada para el " +  entityType  + ":" + entityName + ". Nueva calificación promedio: " + avegareRating;
    notifyObservers(message);
  }
  public LinkedList<IObserver> getObservers() {
    return observers;
  }
}
