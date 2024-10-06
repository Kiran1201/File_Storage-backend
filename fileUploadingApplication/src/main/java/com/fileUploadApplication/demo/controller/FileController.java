package com.fileUploadApplication.demo.controller;

import com.fileUploadApplication.demo.model.File;
import com.fileUploadApplication.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<File> uploadFile(
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("data") MultipartFile file) { // Use MultipartFile

        try {
            byte[] data = file.getBytes(); // Get byte data from MultipartFile
            File savedFile = fileService.storeFile(name, type, data);
            return new ResponseEntity<>(savedFile, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }


    @GetMapping("/search")
    public ResponseEntity<List<File>> searchFilesByName(@RequestParam String name) {
        List<File> files = fileService.searchFilesByName(name);
        return new ResponseEntity<>(files, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable Long id) {
        Optional<File> fileOptional = fileService.getFileById(id);

        if (fileOptional.isPresent()) {
            File file = fileOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                    .contentType(MediaType.APPLICATION_PDF) // Assuming it's a PDF file
                    .body(new ByteArrayResource(file.getData()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
