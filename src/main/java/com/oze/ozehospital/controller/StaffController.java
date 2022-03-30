package com.oze.ozehospital.controller;

import com.oze.ozehospital.pojo.StaffAddRequest;
import com.oze.ozehospital.pojo.StaffUpdateRequest;
import com.oze.ozehospital.repository.StaffRepository;
import com.oze.ozehospital.services.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class StaffController {

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StaffService staffService;

    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @PostMapping("/staff/add")
    public ResponseEntity<?> addStaff(@RequestBody StaffAddRequest staffAddRequest) {
        return staffService.addStaff(staffAddRequest);
    }

    @PostMapping("/staff/update/{uuid}")
    public ResponseEntity<?> updateStaff(@RequestBody StaffUpdateRequest staffUpdateRequest, @PathVariable String uuid) {
        return staffService.updateStaff(staffUpdateRequest, uuid);
    }

}
