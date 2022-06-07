package com.ifast.restaurant.service;

import com.ifast.restaurant.dao.RestaurantDao;
import com.ifast.restaurant.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDao restaurantDao;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantDao.save(restaurant);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantDao.findAll();
    }

    @Override
    public Restaurant getRestaurant(int id) {
        return restaurantDao.findById(id).get();
    }

    @Override
    public void deleteRestaurant(int id) {
        restaurantDao.deleteById(id);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantDao.save(restaurant);
    }
}
