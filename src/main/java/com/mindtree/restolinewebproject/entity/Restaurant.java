package com.mindtree.restolinewebproject.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Restaurant")
public class Restaurant implements Comparable<Restaurant> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Restaurant_Id")
	private int restaurantId;

	@Column(name = "Restaurant_Name")
	@NotNull
	private String restaurantName;

	@Column(name = "Revenue")
	@NotNull
	private double revenue;

	@Column(name = "No_Of_Seat")
	@NotNull
	private int noOfSeat;

	@Column(name = "Fee")
	@NotNull
	private double fee;

	@Column(name = "Extra_Charges")
	@NotNull
	private double extraCharges;

	@JsonIgnore
	@OneToMany(mappedBy = "restaurant")
	private Set<Reservation> reservations;

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restaurantId, String restaurantName, double revenue, int noOfSeat, double fee,
			double extraCharges, Set<Reservation> reservations) {
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.revenue = revenue;
		this.noOfSeat = noOfSeat;
		this.fee = fee;
		this.extraCharges = extraCharges;
		this.reservations = reservations;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public int getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getExtraCharges() {
		return extraCharges;
	}

	public void setExtraCharges(double extraCharges) {
		this.extraCharges = extraCharges;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public int compareTo(Restaurant o) {
		return this.getRestaurantId() - o.getRestaurantId();
	}

}
