package com.mindtree.restolinewebproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.restolinewebproject.service.ReservationService;
import com.mindtree.restolinewebproject.service.UserService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/reservationhistory")
	public String getAllReservationOfUser(Model model) {
		model.addAttribute("reservationlist",
				reservationService.getAllReservationOfUser(userService.getUserById().getUserId()));

		return "reservation-history-page";

	}

	@RequestMapping(value = "/canclebook/{reservationId}")
	public String cancleBooking(@PathVariable int reservationId) {

		reservationService.cancleReservation(reservationId);
		return "redirect:/reservationhistory";

	}

}
