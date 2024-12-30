package org.example.controllers.reviews;

import org.example.services.reviews.dishReview.ShowDishReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

class ShowDishReviewControllerTest {
  @Mock
  private ShowDishReview command;

  @InjectMocks
  private ShowDishReviewController controller;

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