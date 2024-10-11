package com.fileUploadApplication.demo.controller;


import com.fileUploadApplication.demo.model.Folder;
import com.fileUploadApplication.demo.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/folder")
public class FolderController {

    @Autowired
    private FolderService folderService;

    @GetMapping
    public List<Folder> getAllFolders() {
        return folderService.getAllFolders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Folder> getFolderById(@PathVariable Long id) {
        Folder folder = folderService.getFolderById(id).orElseThrow(() -> new RuntimeException("Folder not found"));
        return ResponseEntity.ok(folder);
    }

    @PostMapping
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder) {
        try {
            Folder createdFolder = folderService.createFolder(folder.getFolderName(), folder.getRac().getRacId());
            return new ResponseEntity<>(createdFolder, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Folder updateFolder(@PathVariable Long id, @RequestBody Folder folderDetails) {
        return folderService.updateFolder(id, folderDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFolder(@PathVariable Long id) {
        folderService.deleteFolder(id);
    }
}
