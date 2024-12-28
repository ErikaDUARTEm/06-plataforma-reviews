package org.example.services.interfaces;

import org.example.models.User;

public interface ICommand<T>{
  User execute();
}
