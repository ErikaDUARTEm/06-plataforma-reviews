package org.example.services.interfaces;

<<<<<<< HEAD
import java.util.Observer;
=======
>>>>>>> development

public interface IObservable {
  void addObserver(IObserver observer);
  void removeObserve(IObserver observer);
  void notifyObservers(String message);
}
