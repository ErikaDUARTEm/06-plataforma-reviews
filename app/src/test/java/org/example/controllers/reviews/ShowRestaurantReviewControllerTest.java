package org.example.controllers.reviews;

import org.example.services.reviews.restaurantReview.ShowRestaurantReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

class ShowRestaurantReviewControllerTest {
  @Mock
  private ShowRestaurantReview command;

  @InjectMocks
  private ShowRestaurantReviewController controller;

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