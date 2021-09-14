package com.mindtree.restolinewebproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.restolinewebproject.entity.Restaurant;

@Repository
public interface RestaurantRespository extends JpaRepository<Restaurant, Integer> {

	Optional<Restaurant> findByRestaurantName(String restaurantName);

}
