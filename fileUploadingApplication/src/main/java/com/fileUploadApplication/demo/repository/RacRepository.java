package com.fileUploadApplication.demo.repository;

import com.fileUploadApplication.demo.model.Rac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RacRepository extends JpaRepository<Rac, String> {
    Rac findByRacId(String racId);
}
