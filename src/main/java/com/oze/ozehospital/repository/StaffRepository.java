package com.oze.ozehospital.repository;

import com.oze.ozehospital.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findByUuid(String uuid);
}
