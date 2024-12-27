package org.example.models;

import org.example.services.interfaces.IObserver;

public class User implements IObserver {
  private String name;
  private String email;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public User() {
  }

  @Override
  public void update(String message) {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
