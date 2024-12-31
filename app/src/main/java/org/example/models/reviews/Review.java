package org.example.models.reviews;

public abstract class Review {
  private Double rating;
  private String comment;

  public Review(Double rating, String comment) {
    this.rating = rating;
    this.comment = comment;
  }

  private Review() {
  }

  public abstract String getDetails();

  public Double getRating() {
    return rating;
  }

  public String getComment() {
    return comment;
  }

}
