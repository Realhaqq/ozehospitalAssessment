package com.oze.ozehospital.entities;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "staff")

public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    private String uuid;


    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date  updatedAt;

    @PrePersist
    private void setCreatedAt() {
        registrationDate = new Date();
    }

    @PreUpdate
    private void setUpdatedAt() {
        updatedAt = new Date();
    }

    public Staff() {
    }


    @Override
    public boolean equals(Object staff) {
        return this.id.equals(((Staff)staff).getId());

    }

    @Override
    public String toString() {
        return this.name+" "+this.getName();
    }

}