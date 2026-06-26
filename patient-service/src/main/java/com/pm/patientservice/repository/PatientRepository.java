package com.pm.patientservice.repository;

import com.pm.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// Because of extending JpaRepository we get out of the box crud functionality
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

}
