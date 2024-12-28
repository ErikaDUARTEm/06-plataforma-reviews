package org.example.services.user;

import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.IHandler;

import java.util.List;

public class ShowUser implements ICommand {

  private final UserRepository repository;
  private final IHandler handler;

  public ShowUser(IHandler handler, UserRepository repository){
    this.handler = handler;
    this.repository = repository;
  }

  @Override
  public User execute() {
    List<User> users = repository.getAllUsers();
    for (User user : users) {
      handler.writeLine("Nombre de usuario: " + user.getName() + " | Email: " + user.getEmail());
    }

    return null;
  }

}
