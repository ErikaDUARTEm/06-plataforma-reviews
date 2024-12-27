package org.example.models;

import org.example.services.interfaces.IReviewable;

import java.util.ArrayList;
import java.util.List;


public class ReviewManager implements IReviewable {
  private List<Review> reviews;
  private Double averageRating;
  private Double averageFlavor;
  private Double averageEstablishment;
  private Double averageService;
  private Double averagePresentation;
  private Double averageMenu;

  public ReviewManager() {
    this.reviews = new ArrayList<>();
  }


  @Override
  public void addReview(Review review) {

  }

  @Override
  public void calculateAverageRating() {

  }

  @Override
  public Double getAverageRating() {
    return 0.0;
  }

  @Override
  public List<Review> getReviews() {
    return  reviews;
  }
}
