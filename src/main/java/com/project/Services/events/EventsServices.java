package com.project.Services.events;

import com.project.models.entitys.Event;

import java.util.List;

public interface EventsServices {

    public Event createEvent(Event event);
    public List<Event> getAllEvents();
    public List<Event> getEventByCategory(Long id);
    public List<Event> getEventByPlayer(String name);
    public List<Event> getEventByCoach(String name);
    public Event editEvent(Event event);
    public void deleteEvent(Long id);
    public void closedEvent(Long id);

}
