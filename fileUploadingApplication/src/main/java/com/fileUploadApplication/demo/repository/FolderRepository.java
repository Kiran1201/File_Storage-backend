package com.fileUploadApplication.demo.repository;

import com.fileUploadApplication.demo.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    Optional<Folder> findByFolderName(String folderName);

    @Query("SELECT f FROM Folder f WHERE f.rac.racId = :racId")
    List<Folder> findByRacId(@Param("racId") String racId);
}
