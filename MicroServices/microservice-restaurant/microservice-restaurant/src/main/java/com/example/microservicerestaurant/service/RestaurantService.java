package com.example.microservicerestaurant.service;

import com.example.microservicerestaurant.entities.Restaurant;
import com.example.microservicerestaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
    Optional<Restaurant> getRestaurantById(Long id);
    Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant);
    void deleteRestaurant(Long id);

    @Service
    class RestaurantServiceImpl implements RestaurantService {

        private final RestaurantRepository restaurantRepository;

        @Autowired
        public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
            this.restaurantRepository = restaurantRepository;
        }

        @Override
        public Restaurant addRestaurant(Restaurant restaurant) {
            return restaurantRepository.save(restaurant);
        }

        @Override
        public List<Restaurant> getAllRestaurants() {
            return restaurantRepository.findAll();
        }

        @Override
        public Optional<Restaurant> getRestaurantById(Long id) {
            return restaurantRepository.findById(id);
        }

        @Override
        public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
            Optional<Restaurant> optional = restaurantRepository.findById(id);
            if (optional.isPresent()) {
                Restaurant restaurant = optional.get();
                restaurant.setName(updatedRestaurant.getName());
                restaurant.setLocation(updatedRestaurant.getLocation());
                restaurant.setContactNumber(updatedRestaurant.getContactNumber());
                return restaurantRepository.save(restaurant);
            } else {
                throw new RuntimeException("Restaurant not found with id: " + id);
            }
        }

        @Override
        public void deleteRestaurant(Long id) {
            restaurantRepository.deleteById(id);
        }
    }
}
