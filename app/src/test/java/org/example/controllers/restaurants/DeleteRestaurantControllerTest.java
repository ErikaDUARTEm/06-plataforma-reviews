package org.example.controllers.restaurants;

import org.example.services.restaurant.DeleteRestaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class DeleteRestaurantControllerTest {

  @Mock
  private DeleteRestaurant mockDeleteRestaurant;

  @InjectMocks
  private DeleteRestaurantController deleteRestaurantController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("verifica que se llama a DeleteRestaurant.execute()")
  void testExecute() {
    deleteRestaurantController.execute();

    verify(mockDeleteRestaurant).execute();
  }
}
