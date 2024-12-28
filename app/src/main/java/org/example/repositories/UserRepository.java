package org.example.repositories;

import org.example.models.User;

import java.util.LinkedList;

public class UserRepository {
  private static UserRepository instance;
  private LinkedList<User> users;

  private UserRepository(){
    this.users = new LinkedList<>();
  }
  public static synchronized UserRepository getInstance(){
    if(instance == null){
      instance = new UserRepository();
    }
    return instance;
  }
  public void addUser(User userNew){
     users.add(userNew);
  }
  public LinkedList<User> getAllUsers(){
    return users;
  };
}
