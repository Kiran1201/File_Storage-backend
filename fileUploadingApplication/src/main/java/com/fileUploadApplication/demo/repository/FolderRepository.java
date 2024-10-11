package com.fileUploadApplication.demo.repository;

import com.fileUploadApplication.demo.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
