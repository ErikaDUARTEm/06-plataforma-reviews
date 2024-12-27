package org.example.models;

import org.example.services.interfaces.IObservable;
import org.example.services.interfaces.IObserver;

import java.util.LinkedList;

public class NotificationService implements IObservable {
  private LinkedList<IObserver> observers;


  public NotificationService() {
    this.observers = new LinkedList<>();
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

  public LinkedList<IObserver> getObservers() {
    return observers;
  }

  public void setObservers(LinkedList<IObserver> observers) {
    this.observers = observers;
  }
}
