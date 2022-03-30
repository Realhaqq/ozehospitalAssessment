package com.oze.ozehospital.services;

import com.oze.ozehospital.entities.Staff;
import com.oze.ozehospital.pojo.ApiResponse;
import com.oze.ozehospital.repository.PatientRepository;
import com.oze.ozehospital.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
