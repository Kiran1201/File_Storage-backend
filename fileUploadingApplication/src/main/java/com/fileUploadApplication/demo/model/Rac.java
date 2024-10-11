package com.fileUploadApplication.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rac")
public class Rac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @Column(unique = true, nullable = false) // Ensure unique racId
    private String racId; // String racId

    public Rac() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRacId() {
        return racId;
    }

    public void setRacId(String racId) {
        this.racId = racId;
    }
}