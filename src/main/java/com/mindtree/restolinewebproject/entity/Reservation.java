package com.mindtree.restolinewebproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Reservation")
public class Reservation implements Comparable<Reservation> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Resservation_Id")
	private int reservationId;

	@Column(name = "Payment")
	@NotNull
	private double payment;

	@Column(name = "Booked_Seat")
	@NotNull
	private int bookedSeat;

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@JsonIgnore
	@ManyToOne
	private User user;

	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(int reservationId, double payment, int bookedSeat, Status status, User user,
			Restaurant restaurant) {
		this.reservationId = reservationId;
		this.payment = payment;
		this.bookedSeat = bookedSeat;
		this.status = status;
		this.user = user;
		this.restaurant = restaurant;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public int getBookedSeat() {
		return bookedSeat;
	}

	public void setBookedSeat(int bookedSeat) {
		this.bookedSeat = bookedSeat;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public int compareTo(Reservation o) {

		return this.getReservationId() - o.getReservationId();
	}

}
