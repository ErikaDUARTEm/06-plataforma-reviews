package org.example.controllers.restaurants;

import org.example.services.restaurant.ShowRestaurants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

class ShowRestaurantsControllerTest {

  @Mock
  private ShowRestaurantsController controller;

  @Mock
  private ShowRestaurants command;

  @BeforeEach
  void setUp() {
    command = mock(ShowRestaurants.class);
    controller = new ShowRestaurantsController(command);
  }

  @Test
  void testExecute() {
    controller.execute();
    verify(command).execute();
  }
}
