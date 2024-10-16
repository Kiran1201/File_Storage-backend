package com.fileUploadApplication.demo.repository;

import com.fileUploadApplication.demo.model.Rac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RacRepository extends JpaRepository<Rac, String> {
    Optional<Rac> findByRacId(String racId);
}
