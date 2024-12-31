package org.example.models;

import org.example.services.interfaces.IObserver;

public class User implements IObserver {
  private String name;
  private String email;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  private User() {
  }

  @Override public void update(String message) {
    System.out.println("Notificación para " + name + ": " + message);
  }
  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setId(long l) {
  }
}
