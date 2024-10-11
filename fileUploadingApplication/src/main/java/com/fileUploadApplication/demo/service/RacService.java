package com.fileUploadApplication.demo.service;


import com.fileUploadApplication.demo.model.Rac;
import com.fileUploadApplication.demo.repository.RacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacService {

    @Autowired
    private RacRepository racRepository;

    public List<Rac> getAllRacs() {
        return racRepository.findAll();
    }

    public Optional<Rac> getRacById(String racId) {
        return racRepository.findById(racId);
    }

    public Rac createRac(Rac rac) {
        return racRepository.save(rac);
    }

    public Rac updateRac(String racId, Rac racDetails) {
        Rac rac = racRepository.findById(racId).orElseThrow(() -> new RuntimeException("Rac not found"));
        rac.setRacId(racDetails.getRacId());
        return racRepository.save(rac);
    }

    public void deleteRac(String racId) {
        Rac rac = racRepository.findById(racId).orElseThrow(() -> new RuntimeException("Rac not found"));
        racRepository.delete(rac);
    }
}
