package com.oze.ozehospital.services;

import com.oze.ozehospital.entities.Patient;
import com.oze.ozehospital.entities.Staff;
import com.oze.ozehospital.pojo.ApiResponse;
import com.oze.ozehospital.repository.PatientRepository;
import com.oze.ozehospital.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    PatientRepository patientRepository;


    public ResponseEntity<?> getPatients(String uuid) {
        Staff staff = staffRepository.findByUuid(uuid);
        if (staff == null)
            return ResponseEntity.ok(new ApiResponse(false, "Staff not found", 404, null));


        return ResponseEntity.ok(new ApiResponse(true, "Patients", 200, patientRepository.findAll()));

    }

    public ResponseEntity<?> getPatientsAbove2Years(String uuid) {
        Staff staff = staffRepository.findByUuid(uuid);
        if (staff == null)
            return ResponseEntity.ok(new ApiResponse(false, "Staff not found", 404, null));

        return ResponseEntity.ok(new ApiResponse(true, "Patients", 200, patientRepository.findAllByAgeGreaterThan(2)));
    }

    public ResponseEntity<?> deletePatient(String uuid, Date from, Date to) {
        Staff staff = staffRepository.findByUuid(uuid);
        if (staff == null)
            return ResponseEntity.ok(new ApiResponse(false, "Staff not found", 404, null));


        List<Patient> patient = patientRepository.findAllByCreatedAtBetween(from, to);

        if (patient == null)
            return ResponseEntity.ok(new ApiResponse(false, "Patient not found", 404, null));


        for (Patient p : patient) {
            patientRepository.delete(p);
        }
        return ResponseEntity.ok(new ApiResponse(true, "Patients Deleted Successfully", 200, null));
    }
}
