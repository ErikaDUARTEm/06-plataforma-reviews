package org.example.services.user;

import org.example.utils.NotificationService;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

public class AddUser implements ICommand<User> {

  private final UserRepository repository;
  private final IHandler handler;
  private final NotificationService notificationService;

  public AddUser( UserRepository repository, IHandler handler, NotificationService notificationService){
    this.repository = repository;
    this.handler = handler;
    this.notificationService = notificationService;
  }

  @Override
  public User execute() {
    handler.writeLine("Ingresa el nombre del usuario:");
    String nameUser = handler.readLine();
    handler.writeLine("Ingresa el email:");
    String emailUser = handler.readLine();
    return addNewUser(nameUser, emailUser);
  }
  public User addNewUser(String name, String email){
    User user = new User(name, email);
    notificationService.addObserver(user);
    repository.addUser(user);
    return user;
  }
}
