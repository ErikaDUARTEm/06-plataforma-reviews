package org.example.utils;

import org.example.controllers.interfaces.IController;

import java.util.Map;

public class Menu {
    private final IHandler handler;
    private final Map<Integer, IController> controllers;

    public Menu(IHandler handler, Map<Integer, IController> controllers) {
      this.handler = handler;
      this.controllers = controllers;
    }

    public void start() {
      int option = -1;

      do {
        handler.writeLine("Bienvenid@ selecciona lo que deseas hacer:\n1. Registrar usuario\n2. Mostrar usuario\n3.Agregar Restaurant\n4.Mostrar Restaurantes\n5.Editar Restaurant Restaurant\n0. Salir.");
        try {
          option = Integer.parseInt(handler.readLine());
          IController controller = controllers.get(option);
          if (controller != null) {
            controller.execute();
          } else if (option != 0) {
            handler.writeLine("Opción inválida, por favor intenta de nuevo.");
          }
        } catch (NumberFormatException e) {
          handler.writeLine("Por favor, ingresa un número válido.");
        }
      } while (option != 0);

      handler.writeLine("Saliendo...");
    }

}