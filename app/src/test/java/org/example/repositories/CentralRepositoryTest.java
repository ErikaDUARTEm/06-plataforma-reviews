package org.example.repositories;

import org.example.models.Dish;
import org.example.models.NotificationService;
import org.example.models.Restaurant;
import org.example.models.reviews.DishReview;
import org.example.models.reviews.RestaurantReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CentralRepositoryTest {

  @Mock
  private NotificationService notificationService;

  private CentralRepository centralRepository;

  @BeforeEach
  void setUp() {
    centralRepository = CentralRepository.getInstance(notificationService);

  }
  @Test
  void getInstance() {

    CentralRepository instance1 = CentralRepository.getInstance(notificationService);
    CentralRepository instance2 = CentralRepository.getInstance(notificationService);

    assertNotNull(instance1);
    assertNotNull(instance2);
    assertEquals(instance1, instance2, "Las instancias deben ser las mismas");
  }

  @Test
  void addRestaurant() {
    Restaurant restaurant = mock(Restaurant.class);
    centralRepository.addRestaurant(restaurant);
    assertTrue(centralRepository.getRestaurants().contains(restaurant));
  }

  @Test
  void addDish() {
    Dish dish = mock(Dish.class);
    centralRepository.addDish(dish);
    assertTrue(centralRepository.getDish().contains(dish));
  }

  @Test
  void getDish() {
    Dish dish1 = mock(Dish.class);
    Dish dish2 = mock(Dish.class);

    centralRepository.addDish(dish1);
    centralRepository.addDish(dish2);

    Set<Dish> actualDishes = centralRepository.getDish();
    assertTrue(actualDishes.contains(dish1));
    assertTrue(actualDishes.contains(dish2));
  }

  @Test
  void findRestaurantByName() {
    Restaurant restaurant = mock(Restaurant.class);

    when(restaurant.getName()).thenReturn("Test Restaurant");

    centralRepository.addRestaurant(restaurant);
    Restaurant foundRestaurant = centralRepository.findRestaurantByName("Test Restaurant");

    assertNotNull(foundRestaurant, "El restaurante debería existir.");
    assertEquals("Test Restaurant", foundRestaurant.getName(), "Los nombres deben coincidir.");
  }


  @Test
  void deleteRestaurant() {
    Restaurant restaurant = mock(Restaurant.class);
    centralRepository.addRestaurant(restaurant);

    centralRepository.deleteRestaurant(restaurant);

    assertFalse(centralRepository.getRestaurants().contains(restaurant), "Restaurante eliminado exitosamente.");
  }

  @Test
  void calculateRatingAverageRestaurantReviews() {
    Restaurant restaurant = mock(Restaurant.class);
    when(restaurant.getName()).thenReturn("Test Restaurant");
    RestaurantReview review1 = mock(RestaurantReview.class);
    RestaurantReview review2 = mock(RestaurantReview.class);
    when(review1.getRestaurant()).thenReturn(restaurant);
    when(review2.getRestaurant()).thenReturn(restaurant);
    when(review1.getRating()).thenReturn(4);
    when(review2.getRating()).thenReturn(5);
    when(review1.getServiceRating()).thenReturn(3);
    when(review2.getServiceRating()).thenReturn(4);
    when(review1.getestablishmentRating()).thenReturn(4);
    when(review2.getestablishmentRating()).thenReturn(4);
    when(review1.getMenuRating()).thenReturn(4);
    when(review2.getMenuRating()).thenReturn(5);

    centralRepository.addRestaurantReview(review1);
    centralRepository.addRestaurantReview(review2);
    Double average = centralRepository.calculateRatingAverageRestaurantReviews(restaurant);
    assertEquals(4.125, average);
  }

  @Test
  void testFindRestaurantByNameWithMocks() {
    // Crear un mock del restaurante
    Restaurant restaurant = mock(Restaurant.class);
    when(restaurant.getName()).thenReturn("Test Restaurant");

    // Añadir el restaurante mockeado al repositorio
    centralRepository.addRestaurant(restaurant);

    // Llamar al método que se está probando
    Restaurant result = centralRepository.findRestaurantByName("Test Restaurant");

    // Verificar el resultado
    assertNotNull(result, "El restaurante encontrado no debe ser nulo");
    assertEquals("Test Restaurant", result.getName(), "El nombre del restaurante debe coincidir");
  }


  @Test
  void getReviewByDish() {
    Dish dish = mock(Dish.class);
    DishReview review1 = mock(DishReview.class);
    DishReview review2 = mock(DishReview.class);

    when(review1.getDish()).thenReturn(dish);
    when(review2.getDish()).thenReturn(dish);

    centralRepository.addDishReview(review1);
    centralRepository.addDishReview(review2);

    List<DishReview> reviews = centralRepository.getReviewByDish(dish);

    assertEquals(2, reviews.size());
    assertEquals(review1, reviews.get(0));
    assertEquals(review2, reviews.get(1));
  }

  @Test
  void testCalculateRatingAverageDishReviews() {
    Dish dish = mock(Dish.class);
    DishReview review1 = mock(DishReview.class);
    DishReview review2 = mock(DishReview.class);

    when(review1.getDish()).thenReturn(dish);
    when(review2.getDish()).thenReturn(dish);

    when(review1.getRating()).thenReturn(4);
    when(review2.getRating()).thenReturn(5);

    when(review1.getFlavorRating()).thenReturn(4);
    when(review2.getFlavorRating()).thenReturn(5);

    when(review1.getPresentatioNRating()).thenReturn(3);
    when(review2.getPresentatioNRating()).thenReturn(4);

    centralRepository.addDishReview(review1);
    centralRepository.addDishReview(review2);

    double average = centralRepository.calculateRatingAverageDishReviews(dish);

    assertEquals(4.166666666666667, average, 0.0001);
  }


}