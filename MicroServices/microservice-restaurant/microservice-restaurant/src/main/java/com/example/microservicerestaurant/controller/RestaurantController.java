package com.example.microservicerestaurant.controller;

import com.example.microservicerestaurant.entities.MenuItem;
import com.example.microservicerestaurant.entities.Restaurant;
import com.example.microservicerestaurant.service.MenuItemService;
import com.example.microservicerestaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final MenuItemService menuItemService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService,
                                MenuItemService menuItemService) {
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
    }

    // POST /restaurants
    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant saved = restaurantService.addRestaurant(restaurant);
        return ResponseEntity.ok(saved);
    }

    // GET /restaurants
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    // GET /restaurants/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /restaurants/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,
                                                       @RequestBody Restaurant updatedRestaurant) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(id, updatedRestaurant));
    }

    // DELETE /restaurants/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    // POST /restaurants/{id}/menu-items
    @PostMapping("/{id}/menu-items")
    public ResponseEntity<MenuItem> addMenuItem(@PathVariable Long id,
                                                @RequestBody MenuItem menuItem) {
        MenuItem savedItem = menuItemService.addMenuItem(id, menuItem);
        return ResponseEntity.ok(savedItem);
    }

    // GET /restaurants/{id}/menu-items
    @GetMapping("/{id}/menu-items")
    public ResponseEntity<List<MenuItem>> getMenuItemsByRestaurant(@PathVariable Long id) {
        return ResponseEntity.ok(menuItemService.getMenuItemsByRestaurant(id));
    }
}
