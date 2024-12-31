package org.example.factory;

import org.example.models.reviews.Review;

public interface IReviewFactory<T> {
  Review createReview(Double rating, String comment, T associatedEntity, Double... additionalRatings);
}
