package org.example.models.reviews;

import org.example.models.Dish;

public class DishReview extends Review {
  private Dish dish;
  private Integer flavorRating;
  private Integer presentationRating;

  public DishReview(Integer rating, String comment, Dish dish, Integer flavorRating, Integer presentationRating) {
    super(rating, comment);
    this.dish = dish;
    this.flavorRating = flavorRating;
    this.presentationRating = presentationRating;
  }
  private DishReview(){};

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

  public Integer getFlavorRating() {
    return flavorRating;
  }

  public void setFlavorRating(Integer flavorRating) {
    this.flavorRating = flavorRating;
  }

  public Integer getPresentatioNRating() {
    return presentationRating;
  }

  public void setPresentation(Integer presentationRating) {
    this.presentationRating = presentationRating;
  }


}
