package org.example;

import org.example.controllers.reviews.AddDishReviewController;
import org.example.controllers.restaurants.AddRestaurantController;
import org.example.controllers.reviews.AddRestaurantReviewController;
import org.example.controllers.user.AddUserController;
import org.example.controllers.restaurants.DeleteRestaurantController;
import org.example.controllers.reviews.ShowDishReviewController;
import org.example.controllers.reviews.ShowRestaurantReviewController;
import org.example.controllers.restaurants.ShowRestaurantsController;
import org.example.controllers.user.DisableNotificationsController;
import org.example.controllers.user.ShowUserController;
import org.example.controllers.restaurants.UpdateRestaurantController;
import org.example.controllers.interfaces.IController;
import org.example.factory.DishReviewFactory;
import org.example.factory.RestaurantReviewFactory;
import org.example.utils.NotificationService;
import org.example.repositories.CentralRepository;
import org.example.repositories.UserRepository;
import org.example.services.restaurant.AddRestaurant;
import org.example.services.restaurant.DeleteRestaurant;
import org.example.services.restaurant.ShowRestaurants;
import org.example.services.restaurant.UpdateRestaurant;
import org.example.services.reviews.dishReview.AddDishReview;
import org.example.services.reviews.dishReview.ShowDishReview;
import org.example.services.reviews.restaurantReview.AddRestaurantReview;
import org.example.services.reviews.restaurantReview.ShowRestaurantReview;
import org.example.services.user.AddUser;
import org.example.services.user.DisableNotifications;
import org.example.services.user.ShowUser;
import org.example.utils.ConsoleHandler;
import org.example.utils.IHandler;
import org.example.utils.Menu;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        IHandler handler = new ConsoleHandler();
        UserRepository userRepository = UserRepository.getInstance();
        NotificationService notificationService = new NotificationService();
        CentralRepository centralRepository = CentralRepository.getInstance(notificationService);
        RestaurantReviewFactory restaurantReviewFactory = new RestaurantReviewFactory();
        DishReviewFactory dishReviewFactory = new DishReviewFactory();



        AddUser addUserCommand = new AddUser(userRepository,handler, notificationService);
        ShowUser showUserCommand = new ShowUser(handler, userRepository);
        AddRestaurant addRestaurantCommand = new AddRestaurant(centralRepository, handler);
        UpdateRestaurant updateRestaurantCommand = new UpdateRestaurant(centralRepository,handler);
        ShowRestaurants showRestaurantsCommand = new ShowRestaurants(handler, centralRepository);
        DeleteRestaurant deleteRestaurantCommand = new DeleteRestaurant(centralRepository, handler);
        AddRestaurantReview addRestaurantReviewCommand = new AddRestaurantReview(centralRepository, handler, restaurantReviewFactory, notificationService);
        ShowRestaurantReview showRestaurantReviewCommand = new ShowRestaurantReview(centralRepository, handler);
        AddDishReview addDishReviewCommand = new AddDishReview(centralRepository, handler,dishReviewFactory, notificationService);
        ShowDishReview showDishReviewCommand = new ShowDishReview(centralRepository, handler);
        DisableNotifications disableNotificationsCommand = new DisableNotifications(handler, notificationService);

        Map<Integer, IController> controllers = new HashMap<>();
          controllers.put(1, new AddUserController(addUserCommand));
          controllers.put(2, new ShowUserController(showUserCommand));
          controllers.put(3, new AddRestaurantController(addRestaurantCommand));
          controllers.put(4, new ShowRestaurantsController(showRestaurantsCommand));
          controllers.put(5, new UpdateRestaurantController(updateRestaurantCommand));
          controllers.put(6, new DeleteRestaurantController(deleteRestaurantCommand));
          controllers.put(7, new AddRestaurantReviewController(addRestaurantReviewCommand));
          controllers.put(8, new ShowRestaurantReviewController(showRestaurantReviewCommand));
          controllers.put(9, new AddDishReviewController(addDishReviewCommand));
          controllers.put(10, new ShowDishReviewController(showDishReviewCommand));
          controllers.put(11, new DisableNotificationsController(disableNotificationsCommand));

        Menu menu = new Menu(handler, controllers);
        menu.start();
    }

}
