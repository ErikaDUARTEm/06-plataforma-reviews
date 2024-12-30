package org.example.controllers.restaurants;

import org.example.services.restaurant.UpdateRestaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class UpdateRestaurantControllerTest {

  @Mock
  private UpdateRestaurant mockUpdateRestaurant;

  @InjectMocks
  private UpdateRestaurantController updateRestaurantController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("se prueba que se este llamando UpdateRestaurant.execute()")
  void testExecute() {

    updateRestaurantController.execute();

    verify(mockUpdateRestaurant).execute();
  }
}
