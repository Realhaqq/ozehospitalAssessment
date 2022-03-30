package com.oze.ozehospital.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "patient")

public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    private int age;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date last_visit_date;

    @PrePersist
    private void setCreatedAt() {
        created_at = new Date();
    }

    @PreUpdate
    private void setUpdatedAt() {
        last_visit_date = new Date();
    }

    public Patient() {
    }


    @Override
    public boolean equals(Object patient) {
        return this.id.equals(((Patient)patient).getId());

    }

    @Override
    public String toString() {
        return this.name+" "+this.getName();
    }

}