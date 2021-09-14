package com.mindtree.restolinewebproject.service;

import java.util.Set;

import com.mindtree.restolinewebproject.entity.Reservation;
import com.mindtree.restolinewebproject.entity.User;

public interface ReservationService {

	int bookSeat(int noofseat, int restId, User userById);

	Set<Reservation> getAllReservationOfUser(int i);

	void cancleReservation(int reservationId); 
	
	default int findReservation() {
		return 0;
	};

} 
