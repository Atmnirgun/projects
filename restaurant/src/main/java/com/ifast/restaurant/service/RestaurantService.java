package com.ifast.restaurant.service;

import com.ifast.restaurant.dto.RestaurantDto;
import com.ifast.restaurant.entities.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RestaurantService {

    public Restaurant createRestaurant(Restaurant restaurant);
    public List<Restaurant> findAll();
    public Restaurant getRestaurant(int id);
    public void deleteRestaurant(int id);
    public Restaurant updateRestaurant(Restaurant restaurant);
}



