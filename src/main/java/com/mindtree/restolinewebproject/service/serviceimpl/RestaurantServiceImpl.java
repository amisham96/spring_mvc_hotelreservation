package com.mindtree.restolinewebproject.service.serviceimpl;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restolinewebproject.Exception.service.RestoLineWebProjectServiceException;
import com.mindtree.restolinewebproject.Exception.service.cutom.RestaurantNotFoundException;
import com.mindtree.restolinewebproject.Exception.service.cutom.RestuarntAlreadyExistsException;
import com.mindtree.restolinewebproject.entity.Restaurant;
import com.mindtree.restolinewebproject.repository.RestaurantRespository;
import com.mindtree.restolinewebproject.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRespository restaurantRespository;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestoLineWebProjectServiceException {

		if (restaurantRespository.findByRestaurantName(restaurant.getRestaurantName()).isPresent())
			throw new RestuarntAlreadyExistsException("Restuarnt Already Exits");

		return restaurantRespository.save(restaurant);

	}

	@Override
	public Set<Restaurant> getAllRestaurant() {

		return new TreeSet<Restaurant>(restaurantRespository.findAll());
	}

	@Override
	public Restaurant getRestaurantByID(int id) {

		return restaurantRespository.findById(id).get();
	}

	@Override
	public Restaurant updateRestaurent(Restaurant restaurant, int restaurantId) throws RestoLineWebProjectServiceException {
		// TODO Auto-generated method stub
		Restaurant restaurent1 = restaurantRespository.findById(restaurantId)
				.orElseThrow(() -> new RestaurantNotFoundException("restaurent by this Id not found"));
		restaurent1.setRestaurantName(restaurant.getRestaurantName());
		restaurent1.setRevenue(restaurant.getRevenue());
		restaurent1.setExtraCharges(restaurant.getExtraCharges());
		restaurent1.setFee(restaurant.getFee());
		restaurent1.setNoOfSeat(restaurant.getNoOfSeat());
		return restaurantRespository.save(restaurent1);
	}

}
