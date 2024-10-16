package com.fileUploadApplication.demo.repository;

import com.fileUploadApplication.demo.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    Optional<Folder> findByFolderName(String folderName);
}
