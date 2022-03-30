package com.oze.ozehospital.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class DeletePatientRequest {
    private Date fromDate;
    private Date toDate;
}
