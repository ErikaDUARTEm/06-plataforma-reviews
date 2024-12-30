package org.example.controllers.reviews;

import org.example.services.reviews.restaurantReview.AddRestaurantReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

class AddRestaurantReviewControllerTest {
  @Mock
  private AddRestaurantReview command;

  @InjectMocks
  private AddRestaurantReviewController controller;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }
  @Test
  void testExecute() {
    controller.execute();
    verify(command).execute();
  }

}