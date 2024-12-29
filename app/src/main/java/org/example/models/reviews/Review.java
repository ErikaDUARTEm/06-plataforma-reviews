package org.example.models.reviews;

public abstract class Review {
  private Integer rating;
  private String comment;

  public Review(Integer rating, String comment) {
    this.rating = rating;
    this.comment = comment;
  }

  private Review() {
  }

  public abstract String getDetails();

  public Integer getRating() {
    return rating;
  }

  public String getComment() {
    return comment;
  }

}
