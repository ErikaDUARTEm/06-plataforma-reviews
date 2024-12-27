package org.example.services.interfaces;

import org.example.models.Review;
import java.util.List;

public interface IReviewable {
  void addReview(Review review);
  void calculateAverageRating();
  Double getAverageRating();
  List<Review> getReviews();
}
