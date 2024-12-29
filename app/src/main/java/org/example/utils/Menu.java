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
        handler.writeLine("Bienvenid@ selecciona lo que deseas hacer:");
        handler.writeLine("1. Registrar usuario");
        handler.writeLine("2. Mostrar usuario");
        handler.writeLine("3. Agregar Restaurant");
        handler.writeLine("4. Mostrar Restaurantes");
        handler.writeLine("5. Editar Restaurant");
        handler.writeLine("6. Eliminar restaurante");
        handler.writeLine("7. Crear review de un restaurante");
        handler.writeLine("8. Ver lista de review de un restaurante");
        handler.writeLine("9. Crear review de un plato");
        handler.writeLine("10. Ver review de un plato");
        handler.writeLine("11. Desactivar notificaciones");
        handler.writeLine("0. Salir.");
        handler.writeLine("________________________________________________________");
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
