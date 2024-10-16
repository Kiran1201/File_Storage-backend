package com.fileUploadApplication.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    @ManyToOne // Assuming each file is associated with one RAC
    @JoinColumn(name = "rac_id") // Foreign key column for RAC
    private Rac rac;

    @ManyToOne // Assuming each file is associated with one folder
    @JoinColumn(name = "folder_id") // Foreign key column for Folder
    private Folder folder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Rac getRac() {
        return rac;
    }

    public void setRac(Rac rac) {
        this.rac = rac;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
