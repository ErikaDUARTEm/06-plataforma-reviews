package org.example.services.interfaces;


public interface IObservable {
  void addObserver(IObserver observer);
  void removeObserve(IObserver observer);
  void notifyObservers(String message);
}
