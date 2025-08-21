package com.example.microservicerestaurant.service;

import com.example.microservicerestaurant.entities.MenuItem;
import com.example.microservicerestaurant.entities.Restaurant;
import com.example.microservicerestaurant.repository.MenuItemRepository;
import com.example.microservicerestaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MenuItemService {
    MenuItem addMenuItem(Long restaurantId, MenuItem menuItem);
    List<MenuItem> getMenuItemsByRestaurant(Long restaurantId);
    MenuItem updateMenuItem(Long id, MenuItem menuItem);
    void deleteMenuItem(Long id);

    @Service
    class MenuItemServiceImpl implements MenuItemService {

        private final MenuItemRepository menuItemRepository;
        private final RestaurantRepository restaurantRepository;

        @Autowired
        public MenuItemServiceImpl(MenuItemRepository menuItemRepository,
                                   RestaurantRepository restaurantRepository) {
            this.menuItemRepository = menuItemRepository;
            this.restaurantRepository = restaurantRepository;
        }

        @Override
        public MenuItem addMenuItem(Long restaurantId, MenuItem menuItem) {
            Restaurant restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));
            menuItem.setRestaurant(restaurant);
            return menuItemRepository.save(menuItem);
        }

        @Override
        public List<MenuItem> getMenuItemsByRestaurant(Long restaurantId) {
            Restaurant restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));
            return menuItemRepository.findByRestaurant(restaurant);
        }

        @Override
        public MenuItem updateMenuItem(Long id, MenuItem updatedItem) {
            Optional<MenuItem> optional = menuItemRepository.findById(id);
            if (optional.isPresent()) {
                MenuItem menuItem = optional.get();
                menuItem.setName(updatedItem.getName());
                menuItem.setDescription(updatedItem.getDescription());
                menuItem.setPrice(updatedItem.getPrice());
                return menuItemRepository.save(menuItem);
            } else {
                throw new RuntimeException("MenuItem not found with id: " + id);
            }
        }

        @Override
        public void deleteMenuItem(Long id) {
            menuItemRepository.deleteById(id);
        }
    }
}
