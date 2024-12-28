package org.example.services.user;

import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

public class AddUser implements ICommand<User> {

  private final UserRepository repository;
  private final IHandler handler;

  public AddUser( UserRepository repository, IHandler handler){
    this.repository = repository;
    this.handler = handler;
  }

  @Override
  public User execute() {
    handler.writeLine("Ingresa el nombre del usuario");
    String nameUser = handler.readLine();
    handler.writeLine("Ingresa el email");
    String emailUser = handler.readLine();
    return addNewUser(nameUser, emailUser);
  }
  public User addNewUser(String name, String email){
    User user = new User(name, email);
    repository.addUser(user);
    return user;
  }
}
