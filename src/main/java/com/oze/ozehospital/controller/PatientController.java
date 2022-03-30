package com.oze.ozehospital.controller;

import com.oze.ozehospital.pojo.DeletePatientRequest;
import com.oze.ozehospital.repository.PatientRepository;
import com.oze.ozehospital.services.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @GetMapping("/patients/all/{uuid}")
    public ResponseEntity<?> getPatientsAll(@PathVariable String uuid) {
        return patientService.getPatients(uuid);
    }


    @GetMapping("/patients/above2years/{uuid}")
    public ResponseEntity<?> getPatientsAbove2Years(@PathVariable String uuid) {
        return patientService.getPatientsAbove2Years(uuid);
    }


    @DeleteMapping("/patients/{uuid}")
    public ResponseEntity<?> deletePatient(@PathVariable String uuid, @RequestBody DeletePatientRequest deletePatientRequest) {
        return patientService.deletePatient(uuid, deletePatientRequest.getFromDate(), deletePatientRequest.getToDate());
    }

    @GetMapping("/patients/download/{uuid}/{patientId}")
    public ResponseEntity<?> getPatientsDownload(@PathVariable String uuid, @PathVariable Long patientId) {
        return patientService.getPatientsDownload(uuid, patientId);
    }

}
