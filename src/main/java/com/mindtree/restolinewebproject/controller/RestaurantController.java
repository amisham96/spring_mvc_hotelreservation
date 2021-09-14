package com.mindtree.restolinewebproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.restolinewebproject.Exception.RestoLineWebProjectException;
import com.mindtree.restolinewebproject.dto.ResponseBodys;
import com.mindtree.restolinewebproject.entity.Restaurant;
import com.mindtree.restolinewebproject.service.ReservationService;
import com.mindtree.restolinewebproject.service.RestaurantService;
import com.mindtree.restolinewebproject.service.UserService;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserService userService;

	static int restaurantid;

	@ResponseBody
	@PostMapping("/addRestaurant")
	public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant) throws RestoLineWebProjectException {
		return new ResponseEntity<ResponseBodys<Restaurant>>(new ResponseBodys<Restaurant>(
				restaurantService.addRestaurant(restaurant), null, "Resturant Added", true), HttpStatus.OK);
	}

	@RequestMapping("/restaurants")
	public String getAllRestaurant(Model model) {
		model.addAttribute("restaurantlist", restaurantService.getAllRestaurant());
		return "show-restaurants-page";
	}

	@RequestMapping(value = "booknow/{id}")
	public String reserved(@PathVariable int id, Model model) {
		restaurantid = id;
		// model.addAttribute("user", userService.getUserById());

		model.addAttribute("restaurant", restaurantService.getRestaurantByID(id));
		// WeSystem.out.println(userService.getUserById().getEmail());
		return "book-seat-page";
	}

	@RequestMapping(value = "booknow/{id}/reserved", method = RequestMethod.POST)
	public String bookSeat(@ModelAttribute("“noofseat”") int noofseat) {
		// System.out.println(noofseat);
		int result = reservationService.bookSeat(noofseat, restaurantid, userService.getUserById());

		if (result == 0) {
			return "error-book-page1";
		} else if (result == 1) {
			return "error-book-page2";

		} else if (result == 2) {
			return "error-book-page3";

		} else if (result == 3) {
			return "error-book-page4";
		} else {
			return "success-book-page";
		}

	}

	@ResponseBody
	@PutMapping("/updateRestaurent/{restaurantId}")
	public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable int restaurantId)
			throws RestoLineWebProjectException {
		return new ResponseEntity<ResponseBodys<Restaurant>>(
				new ResponseBodys<Restaurant>(restaurantService.updateRestaurent(restaurant, restaurantId), null,
						"Resturant Updated", true),
				HttpStatus.OK);
	}
}
