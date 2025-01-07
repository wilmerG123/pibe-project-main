package com.project.controller;

import com.project.Services.Escuela.EscuelaService;
import com.project.models.entitys.Escuela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escuela")
public class EscuelaController {

    @Autowired
    private EscuelaService escuelaService;

    @PostMapping("/create-escuela")
    public ResponseEntity<Escuela> createEscuela(@RequestBody Escuela escuela) {
        Escuela escuelaSaved = escuelaService.createEscuela(escuela);
        return new ResponseEntity<>(escuelaSaved, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-escuela")
    public ResponseEntity<List<Escuela>> getAllEscuela() {
        List<Escuela> escuelasResults = escuelaService.getAllEscuela();
        return new ResponseEntity<>(escuelasResults, HttpStatus.OK);
    }

    @PostMapping("/get-escuela-by-id-escuela/{id}")
    public ResponseEntity<Escuela> getEscuelaById(@PathVariable Long id) {
        Escuela escuelaResult = escuelaService.getEscuelaById(id);
        return new ResponseEntity<>(escuelaResult, HttpStatus.OK);
    }

    @PostMapping("/edit-escuela/{id}")
    public ResponseEntity<Escuela> createEscuela(@RequestBody Escuela escuela, @PathVariable Long id) {
        Escuela escuelaEdit = escuelaService.editEscuela(escuela, id);
        return new ResponseEntity<>(escuelaEdit, HttpStatus.CREATED);
    }

    @PostMapping("/create-escuela")
    public ResponseEntity<Void> deleteEscuela(@PathVariable Long id) {
        escuelaService.deleteEscuela(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
