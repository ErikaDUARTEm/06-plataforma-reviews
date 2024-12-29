package org.example.models;

public class DishReview extends Review{
  private Dish dish;
  private Integer flavorRating;
  private Integer presentationRating;

  public DishReview(Integer rating, String comment, Dish dish, Integer flavorRating, Integer presentationRating) {
    super(rating, comment);
    this.dish = dish;
    this.flavorRating = flavorRating;
    this.presentationRating = presentationRating;
  }
  public DishReview(){};

  @Override public String getDetails() {
    return "Restaurant: " + dish.getName() + ", "+ "Calificación" + getRating() +
      ", Comentario: " + getComment();
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
