package com.fileUploadApplication.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "folder")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String folderName;

    @ManyToOne // Assuming each folder belongs to one RAC
    @JoinColumn(name = "rac_id", nullable = false) // Foreign key column
    private Rac rac;

    public Folder() {
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Rac getRac() {
        return rac;
    }

    public void setRac(Rac rac) {
        this.rac = rac;
    }
}