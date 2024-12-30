package org.example.services.restaurant;

import org.example.models.Dish;
import org.example.repositories.CentralRepository;
import org.example.utils.IHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AddDishTest {

  @Mock
  private IHandler mockHandler;

  @Mock
  private CentralRepository mockRepository;

  @InjectMocks
  private AddDish addDish;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("agregar nuevos platos")
  void testCreateDishMultiple() {

    when(mockHandler.readLine()).thenReturn("Pizza", "10.5", "Pasta", "8.0", "");

    Set<Dish> result = addDish.createDish();

    verifyHandlerMessages();

    verifyDishesAddedToRepository();

    verifyResultDishes(result);
  }

  @Test
  @DisplayName("cuando no se agregan platos")
  void testCreateDishNone() {

    when(mockHandler.readLine()).thenReturn("");

    Set<Dish> result = addDish.createDish();

    verify(mockHandler).writeLine("Ingresa el nombre del plato (o presiona Enter para finalizar)");

    verify(mockRepository, never()).addDish(any(Dish.class));

    assertEquals(0, result.size());
  }

  private void verifyHandlerMessages() {
    verify(mockHandler, times(3)).writeLine("Ingresa el nombre del plato (o presiona Enter para finalizar)");
    verify(mockHandler, times(2)).writeLine("Ingresa el precio del plato");
  }

  private void verifyDishesAddedToRepository() {
    ArgumentCaptor<Dish> dishCaptor = ArgumentCaptor.forClass(Dish.class);
    verify(mockRepository, times(2)).addDish(dishCaptor.capture());

    List<Dish> capturedDishes = dishCaptor.getAllValues();
    assertTrue(capturedDishes.stream().anyMatch(d -> "Pizza".equals(d.getName()) && d.getPrice() == 10.5));
    assertTrue(capturedDishes.stream().anyMatch(d -> "Pasta".equals(d.getName()) && d.getPrice() == 8.0));
  }

  private void verifyResultDishes(Set<Dish> result) {
    assertEquals(2, result.size());
    assertTrue(result.stream().anyMatch(d -> "Pizza".equals(d.getName()) && d.getPrice() == 10.5));
    assertTrue(result.stream().anyMatch(d -> "Pasta".equals(d.getName()) && d.getPrice() == 8.0));
  }
}
