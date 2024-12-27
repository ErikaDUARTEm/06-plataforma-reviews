package org.example.factory;

import org.example.models.Review;

public interface IReviewFactory<T> {
  Review createReview(int rating, String comment, T associatedEntity);
}
