package com.project.controller;

import com.project.Services.events.EventServiceImp;
import com.project.models.dtos.EventDTO;
import com.project.models.entitys.Event;
import com.project.models.entitys.Player;
import com.project.models.enums.Status;
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
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventServiceImp service;

    @PostMapping("create-event")
    public ResponseEntity<Event> saveEvent(@RequestBody EventDTO event) {
        Event entityEvent = new Event(event);
        Event eventSaved = service.createEvent(entityEvent);
        return new ResponseEntity<Event>(eventSaved, HttpStatus.CREATED);
    }

    @GetMapping("get-all-event")
    public ResponseEntity<List<Event>> getAllEvent() {
        List<Event> eventAll = service.getAllEvents();
        return new ResponseEntity<List<Event>>(eventAll, HttpStatus.CREATED);
    }

    @GetMapping("/get-events-by-category/{id}")
    public ResponseEntity<List<Event>> getEventsByCategory(@PathVariable Long id){
        List<Event> eventByCategory = service.getEventByCategory(id);
        return new ResponseEntity<List<Event>>(eventByCategory, HttpStatus.OK);
    }

    @PutMapping("edit-event/{id}")
    public ResponseEntity<Event> editEvent(@RequestBody EventDTO event, @PathVariable Long id) {
        Event entityEvent = new Event(event);
        entityEvent.setId(id);
        Event eventEdit = service.editEvent(entityEvent);
        return new ResponseEntity<>(eventEdit, HttpStatus.CREATED);
    }

    @DeleteMapping("delete-event/{id}")
    public void deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
    }

    @DeleteMapping("closed-event/{id}")
    public void closedEvent(@PathVariable Long id) {
        service.closedEvent(id);
    }

}
