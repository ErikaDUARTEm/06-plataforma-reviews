package org.example.controllers.restaurants;

import org.example.services.restaurant.AddRestaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class AddRestaurantControllerTest {

  @Mock
  private AddRestaurant command;

  @InjectMocks
  private AddRestaurantController controller;

  @BeforeEach
  void setUp() {
    command = mock(AddRestaurant.class);
    controller = new AddRestaurantController(command);
  }

  @Test
  void testExecute() {
    controller.execute();
    verify(command).execute();
    System.out.println("Restaurante agregado exitosamente.");
  }
}
