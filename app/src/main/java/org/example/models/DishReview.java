package org.example.models;

public class DishReview extends Review{
  private Dish dish;
  private Integer flavor;
  private Integer presentation;


  public DishReview(Integer rating, String comment, Dish dish, Integer flavor, Integer presentation) {
    super(rating, comment);
    this.dish = dish;
    this.flavor = flavor;
    this.presentation = presentation;
  }
  public DishReview(){};

  public Dish getDish() {
    return dish;
  }

  public void setDish(Dish dish) {
    this.dish = dish;
  }

  public Integer getFlavor() {
    return flavor;
  }

  public void setFlavor(Integer flavor) {
    this.flavor = flavor;
  }

  public Integer getPresentation() {
    return presentation;
  }

  public void setPresentation(Integer presentation) {
    this.presentation = presentation;
  }


}
