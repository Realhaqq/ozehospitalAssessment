package com.oze.ozehospital.controllers;

import com.oze.ozehospital.pojos.StaffAddRequest;
import com.oze.ozehospital.pojos.StaffUpdateRequest;
import com.oze.ozehospital.repositories.StaffRepository;
import com.oze.ozehospital.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class StaffController {

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StaffService staffService;

    @PostMapping("/staff/add")
    public ResponseEntity<?> addStaff(@Valid @RequestBody StaffAddRequest staffAddRequest) {
        return staffService.addStaff(staffAddRequest);
    }

    @PutMapping("/staff/update/{uuid}")
    public ResponseEntity<?> updateStaff(@RequestBody StaffUpdateRequest staffUpdateRequest, @PathVariable String uuid) {
        return staffService.updateStaff(staffUpdateRequest, uuid);
    }

}
