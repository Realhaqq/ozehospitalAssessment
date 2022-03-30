package com.oze.ozehospital.repositories;

import com.oze.ozehospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAllByAgeGreaterThan(int i);

    List<Patient> findAllByCreatedAtBetween(Date from, Date to);
}
