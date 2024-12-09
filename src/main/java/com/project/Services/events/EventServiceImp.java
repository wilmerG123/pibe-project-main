package com.project.Services.events;

import com.project.models.entitys.Event;
import com.project.models.entitys.Player;
import com.project.models.enums.Status;
import com.project.repository.EventsRepository;
import com.project.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImp implements EventsServices {

    private EventsRepository eventsRepository;
    private PlayerRepository playerRepository;

    public EventServiceImp(EventsRepository eventsRepository,
                           PlayerRepository playerRepository) {
        this.eventsRepository = eventsRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public Event createEvent(Event event) {
        event.setStatus(Status.OPEN);
        if (event != null && event.getCategories() != null && !event.getCategories().isEmpty()) {

            for (int i = 0; i < event.getCategories().size(); i++) {
                List<Player> playersOnEvent = playerRepository.findByCategoryId(event.getCategories().get(i).getId());
                event.getPlayers().addAll(playersOnEvent);
            }
        }
        return eventsRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> eventos = eventsRepository.findAll();
        if (eventos != null && !eventos.isEmpty()) {
            eventos = eventos.stream().filter(e -> Status.OPEN.name().equalsIgnoreCase(e.getStatus().name())).collect(Collectors.toList());
        }
        return eventos;
    }

    @Override
    public List<Event> getEventByCategory(Long id) {
        return eventsRepository.findByCategoriesId(id);
    }

    @Override
    public List<Event> getEventByPlayer(String name) {
        return null;
    }

    @Override
    public List<Event> getEventByCoach(String name) {
        return null;
    }

    @Override
    public Event editEvent(Event event) {
        event.setStatus(Status.OPEN);
        if (event != null && event.getCategories() != null && !event.getCategories().isEmpty()) {
            for (int i = 0; i < event.getCategories().size(); i++) {
                List<Player> playersOnEvent = playerRepository.findByCategoryId(event.getCategories().get(i).getId());
                event.getPlayers().addAll(playersOnEvent);
            }
        }
        return eventsRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventsRepository.deleteById(id);
    }

    @Override
    public void closedEvent(Long id) {
        Optional<Event> event = eventsRepository.findById(id);
        if (event != null && event.get() != null && event.get().getStatus() != null) {
            Event eventColsed = event.get();
            eventColsed.setStatus(Status.CLOSED);
            eventsRepository.save(eventColsed);
        }
    }
}
