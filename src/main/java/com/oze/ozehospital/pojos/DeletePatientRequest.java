package com.oze.ozehospital.pojos;

import lombok.Data;

import java.util.Date;

@Data
public class DeletePatientRequest {
    private Date fromDate;
    private Date toDate;
}
