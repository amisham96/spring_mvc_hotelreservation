package com.mindtree.restolinewebproject.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id")
	private int userId;

	@Column(name = "UserName")
	@NotNull
	private String userName;

	@Column(name = "Email")
	@NotNull
	private String email;

	@Column(name = "Password")
	@NotNull
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Reservation> reservation;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String email, String password, Set<Reservation> reservation) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.reservation = reservation;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}

}
