package org.example.repositories;


import org.example.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserRepositoryTest {
  private UserRepository userRepository;
  @Mock
  private LinkedList<User> mockedUsersList;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.openMocks(this);
    userRepository = UserRepository.getInstance();

    Field usersField = UserRepository.class.getDeclaredField("users");
    usersField.setAccessible(true);
    usersField.set(userRepository, mockedUsersList);
  }

  @Test
  void getInstance() {

    UserRepository instance1 = userRepository.getInstance();
    UserRepository instance2 = userRepository.getInstance();

    assertNotNull(instance1);
    assertNotNull(instance2);
    assertEquals(instance1, instance2, "Las instancias deben ser las mismas");
  }
  @Test
  public void testAddUser() {
    User newUser = mock(User.class);
    userRepository.addUser(newUser);

   verify(mockedUsersList).add(newUser);

  }

  @Test
  public void testGetAllUsers() {
    LinkedList<User> actualUsers = userRepository.getAllUsers();

    assertEquals(mockedUsersList, actualUsers);
  }
}
