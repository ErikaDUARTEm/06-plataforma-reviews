package org.example.models.reviews;

import org.example.models.Dish;

public class DishReview extends Review {
  private Dish dish;
  private Double flavorRating;
  private Double presentationRating;

  public DishReview(Double rating, String comment, Dish dish, Double flavorRating, Double presentationRating) {
    super(rating, comment);
    this.dish = dish;
    this.flavorRating = flavorRating;
    this.presentationRating = presentationRating;
  }

  @Override public String getDetails() {
    return "Plato: " + dish.getName() + ",\n "+ "Calificación: " + getRating() +
      ",\n Comentario: " + getComment();
  }

  public Dish getDish() {
    return dish;
  }

  public void setDish(Dish dish) {
    this.dish = dish;
  }

  public Double getFlavorRating() {
    return flavorRating;
  }

  public Double getPresentatioNRating() {
    return presentationRating;
  }


}
