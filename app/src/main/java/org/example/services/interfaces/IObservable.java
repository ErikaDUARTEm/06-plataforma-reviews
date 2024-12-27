package org.example.services.interfaces;

import java.util.Observer;

public interface IObservable {
  void addObserver(IObserver observer);
  void removeObserve(IObserver observer);
  void notifyObservers(String message);
}
