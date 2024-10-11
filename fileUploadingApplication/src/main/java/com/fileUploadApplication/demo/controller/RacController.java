package com.fileUploadApplication.demo.controller;


import com.fileUploadApplication.demo.model.Rac;
import com.fileUploadApplication.demo.service.RacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/rac")
public class RacController {

    @Autowired
    private RacService racService;

    @GetMapping
    public List<Rac> getAllRacs() {
        return racService.getAllRacs();
    }

    @GetMapping("/{racId}")
    public ResponseEntity<Rac> getRacById(@PathVariable String racId) {
        Rac rac = racService.getRacById(racId).orElseThrow(() -> new RuntimeException("Rac not found"));
        return ResponseEntity.ok(rac);
    }

    @PostMapping
    public Rac createRac(@RequestBody Rac rac) {
        return racService.createRac(rac);
    }

    @PutMapping("/{racId}")
    public Rac updateRac(@PathVariable String racId, @RequestBody Rac racDetails) {
        return racService.updateRac(racId, racDetails);
    }

    @DeleteMapping("/{racId}")
    public void deleteRac(@PathVariable String racId) {
        racService.deleteRac(racId);
    }
}
