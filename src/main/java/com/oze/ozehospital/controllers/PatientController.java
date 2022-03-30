package com.oze.ozehospital.controllers;

import com.oze.ozehospital.pojos.DeletePatientRequest;
import com.oze.ozehospital.repositories.PatientRepository;
import com.oze.ozehospital.services.PatientService;
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
