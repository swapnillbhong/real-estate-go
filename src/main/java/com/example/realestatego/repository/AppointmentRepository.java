package com.example.realestatego.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realestatego.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
