package com.oze.ozehospital.services;

import com.oze.ozehospital.entities.Staff;
import com.oze.ozehospital.pojos.ApiResponse;
import com.oze.ozehospital.pojos.StaffAddRequest;
import com.oze.ozehospital.pojos.StaffUpdateRequest;
import com.oze.ozehospital.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    public ResponseEntity<?> addStaff(StaffAddRequest staffAddRequest) {
        if (staffAddRequest.getName() == null)
            return ResponseEntity.ok(new ApiResponse(false, "Staff name is required", 404, null));

        String uuid = UUID.randomUUID().toString();

        Staff staff = new Staff();
        staff.setName(staffAddRequest.getName());
        staff.setUuid(uuid);
        staffRepository.save(staff);
        return ResponseEntity.ok(new ApiResponse(true, "Staff added successfully", 000, staff));
    }

    public ResponseEntity<?> updateStaff(StaffUpdateRequest staffUpdateRequest, String uuid) {
        Staff staff = staffRepository.findByUuid(uuid);
        if (staff == null)
            return ResponseEntity.ok(new ApiResponse(false, "Staff not found", 404, null));


        if (staffUpdateRequest.getName() == null)
            return ResponseEntity.ok(new ApiResponse(false, "Staff name is required", 404, null));


        staff.setName(staffUpdateRequest.getName());
        staffRepository.save(staff);
        return ResponseEntity.ok(new ApiResponse(true, "Staff updated successfully", 000, staff));
    }
}
