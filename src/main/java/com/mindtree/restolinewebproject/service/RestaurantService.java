package com.mindtree.restolinewebproject.service;

import java.util.Set;

import com.mindtree.restolinewebproject.Exception.service.RestoLineWebProjectServiceException;
import com.mindtree.restolinewebproject.entity.Restaurant;

public interface RestaurantService {

	Restaurant addRestaurant(Restaurant restaurant) throws RestoLineWebProjectServiceException;

	Set<Restaurant> getAllRestaurant();

	Restaurant getRestaurantByID(int id);

	Restaurant updateRestaurent(Restaurant restaurant, int restaurantId) throws RestoLineWebProjectServiceException; 

}
