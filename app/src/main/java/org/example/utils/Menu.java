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
        handler.writeLine("________________________________________________________");
        handler.writeLine("Bienvenid@ selecciona lo que deseas hacer:\n1. Registrar usuario\n2. Mostrar usuario\n3.Agregar Restaurant\n4.Mostrar Restaurantes\n5.Editar Restaurant\n6.Eliminar restaurante\n7.Crear review de un restaurante\n8.Ver lista de review de un restaurante\n9.Crear review de un plato\n0. Salir.");
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
