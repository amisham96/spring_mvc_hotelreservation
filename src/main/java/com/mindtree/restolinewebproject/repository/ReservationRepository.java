package com.mindtree.restolinewebproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.restolinewebproject.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
