package com.fileUploadApplication.demo.service;

import com.fileUploadApplication.demo.model.File;
import com.fileUploadApplication.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;


    public File storeFile(String name, String type, byte[] data) throws IOException {
        File file = new File();
        file.setName(name);
        file.setType(type);
        file.setData(data);
        return fileRepository.save(file);
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public Optional<File> getFileById(Long id) {
        return fileRepository.findById(id);
    }

    public List<File> searchFilesByName(String name) {
        return fileRepository.findByNameContainingIgnoreCase(name);
    }

    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }





}
