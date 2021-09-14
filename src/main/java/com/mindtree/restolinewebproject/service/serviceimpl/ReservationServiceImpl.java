package com.mindtree.restolinewebproject.service.serviceimpl;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restolinewebproject.entity.Reservation;
import com.mindtree.restolinewebproject.entity.Restaurant;
import com.mindtree.restolinewebproject.entity.Status;
import com.mindtree.restolinewebproject.entity.User;
import com.mindtree.restolinewebproject.repository.ReservationRepository;
import com.mindtree.restolinewebproject.repository.RestaurantRespository;
import com.mindtree.restolinewebproject.repository.UserRepository;
import com.mindtree.restolinewebproject.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private RestaurantRespository restaurantRespository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public int bookSeat(int noofseat, int restId, User userById) {

		Restaurant restaurant = restaurantRespository.findById(restId).get();
		if (noofseat > 6) {
			return 0;
		} else if (restaurant.getNoOfSeat() == 0) {
			return 1;
		} else if (noofseat > 2 && restaurant.getNoOfSeat() == 2) {
			return 2;

		} else if (noofseat > restaurant.getNoOfSeat()) {
			return 3;
		} else {
			double payment = noofseat * restaurant.getFee() + noofseat * restaurant.getExtraCharges();
			Reservation reservation = new Reservation();
			reservation.setUser(userById);
			reservation.setBookedSeat(noofseat);
			reservation.setPayment(payment);
			reservation.setStatus(Status.Reserved);
			int updateseat = restaurant.getNoOfSeat() - noofseat;
			restaurant.setNoOfSeat(updateseat);
			reservation.setRestaurant(restaurant);

			reservationRepository.save(reservation);
			return 4;
		}

	}

	@Override
	public Set<Reservation> getAllReservationOfUser(int userId) {

		return new TreeSet<Reservation>(userRepository.findById(userId).get().getReservation());
	}

	@Override
	public void cancleReservation(int reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId).get();
		if (!reservation.getStatus().equals(Status.Cancelled)) {
			Restaurant restaurent = reservation.getRestaurant();
			restaurent.setNoOfSeat(restaurent.getNoOfSeat() + reservation.getBookedSeat());
			double pay = reservation.getPayment() - reservation.getPayment() * 0.4;
			reservation.setStatus(Status.Cancelled);
			reservation.setPayment(pay);
		}
		reservationRepository.save(reservation);

	}

}
