package org.example.factory;

import org.example.models.reviews.Review;

public interface IReviewFactory<T> {
  Review createReview(int rating, String comment, T associatedEntity, Integer... additionalRatings);
}
