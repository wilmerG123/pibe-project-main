package com.project.controller;

import com.project.Services.Coach.CoachServicesImpl;
import com.project.models.dtos.CoachDTO;
import com.project.models.entitys.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    CoachServicesImpl coachServices;

    @PostMapping("/create-coach")
    public ResponseEntity<Coach> createCoach(@RequestBody CoachDTO coach) {
        Coach coachEntity= new Coach(coach);
        Coach savedCoach = coachServices.saveCoach(coachEntity);
        return new ResponseEntity<>(savedCoach, HttpStatus.CREATED);
    }

    @PutMapping("/edit-coach/{id}")
    public ResponseEntity<Coach> editCoach(@RequestBody CoachDTO coach, @PathVariable  Long id){
        Coach coachEntity= new Coach(coach);
        coachEntity.setId(id);
        Coach editedCoach = coachServices.editCoach(coachEntity, id);
        return new ResponseEntity<>(editedCoach, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-coach")
    public ResponseEntity<List<Coach>> getAllCoach(){
        List<Coach> coachs = coachServices.getAllCoach();
        return new ResponseEntity<>(coachs, HttpStatus.OK);
    }

    @GetMapping("/get-by-category-id/{id}")
    public ResponseEntity<List<Coach>> getCoachByCategoryId(@PathVariable Long id){
        List<Coach> coachs = coachServices.getAllCoachByCategory(id);
        return new ResponseEntity<>(coachs, HttpStatus.OK);
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<List<Coach>> getCoachByName(@PathVariable String name){
        List<Coach> coachs = coachServices.getCoachByName(name);
        return new ResponseEntity<>(coachs, HttpStatus.OK);
    }

    @DeleteMapping("/delete-coach/{id}")
    public void deleteCoach(@PathVariable Long id){
        coachServices.deleteById(id);
    }

}
