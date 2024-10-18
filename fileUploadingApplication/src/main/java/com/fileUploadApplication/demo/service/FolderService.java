package com.fileUploadApplication.demo.service;

import com.fileUploadApplication.demo.model.Folder;
import com.fileUploadApplication.demo.model.Rac;
import com.fileUploadApplication.demo.repository.FolderRepository;
import com.fileUploadApplication.demo.repository.RacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private RacRepository racRepository;

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    public Optional<Folder> getFolderById(Long id) {
        return folderRepository.findById(id);
    }

    public Folder createFolder(String folderName, String racId) {
        Rac rac = racRepository.findByRacId(racId)
                .orElseThrow(() -> new RuntimeException("RAC not found"));

        Folder folder = new Folder();
        folder.setFolderName(folderName);
        folder.setRac(rac); // Set the rac object

        return folderRepository.save(folder); // Save folder
    }

    public Folder updateFolder(Long id, Folder folderDetails) {
        Folder folder = folderRepository.findById(id).orElseThrow(() -> new RuntimeException("Folder not found"));
        folder.setFolderName(folderDetails.getFolderName());
        folder.setRac(folderDetails.getRac());
        return folderRepository.save(folder);
    }

    public void deleteFolder(Long id) {
        Folder folder = folderRepository.findById(id).orElseThrow(() -> new RuntimeException("Folder not found"));
        folderRepository.delete(folder);
    }
    public List<Folder> getFoldersByRacId(Long racId) {
        return folderRepository.findByRacId(racId);
    }

}