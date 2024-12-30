package org.example.services.user;

import org.example.models.NotificationService;
import org.example.models.User;
import org.example.services.interfaces.ICommand;
import org.example.services.interfaces.IObserver;
import org.example.utils.IHandler;

import java.util.List;

public class DisableNotifications implements ICommand {
  IHandler handler;
  NotificationService notificationService;

  public DisableNotifications(IHandler handler, NotificationService notificationService) {
    this.handler = handler;
    this.notificationService = notificationService;
  }

  @Override
  public IObserver execute() {
    return disableNotification();
  }
  public IObserver disableNotification(){
    handler.writeLine("Escribe tu nombre:");
    String userName = handler.readLine();
    if (validateName(userName)) return null;

    handler.writeLine("Escribe tu email:");
    String userEmail = handler.readLine();
    if (validateEmail(userEmail)) return null;
    handler.writeLine("Si deseas desactivar las notificaciones escribe 'Si'");
    String option = handler.readLine();

    if(option.equalsIgnoreCase("Si")){
      List<IObserver> observers = notificationService.getObservers();
      boolean userFound = removeUserObserver(observers, userName, userEmail);

      if(!userFound){
        handler.writeLine("No se encontro el usuario en la lista de suscritos");
      }
    }else{handler.writeLine("Escribe la palabra correcta para desactivar las notificaciones.");
    }
    return null;
  }
  private boolean removeUserObserver(List<IObserver> observers, String userName, String userEmail){
    for (IObserver observer : observers) {
      if (observer instanceof User) {
        User user = (User) observer;
        if (user.getEmail().equals(userEmail) && user.getName().equals(userName)) {
          notificationService.removeObserve(observer);
          handler.writeLine("Accion exitosa, no recibiras mas notificaciones");
          return true;
        }
      }
    }
    return false;
  }
  private Boolean validateName(String userName){
    if (userName == null || userName.trim().isEmpty()) {
      handler.writeLine("El nombre no puede ser vacio.");
      return true;
    }
    return false;
  }
  private Boolean validateEmail(String userEmail){
    if (userEmail == null || userEmail.trim().isEmpty()) {
      handler.writeLine("El email no puede ser vacio.");
      return true;
    }
    return false;
  }
}
