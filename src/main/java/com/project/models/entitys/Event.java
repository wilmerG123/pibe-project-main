package com.project.models.entitys;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.models.dtos.EventDTO;
import com.project.models.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Date date;
    private Status status;

    @ManyToOne
    private Cancha cancha;

    @ManyToMany
    @JoinTable(
            name = "event_player",  // Tabla intermedia
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    @JsonManagedReference
    private List<Player> players;

    @ManyToMany
    @JoinTable(
            name = "event_category",  // Tabla intermedia
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonManagedReference
    private List<Category> categories;

    public Event() {
    }


    public Event(Long id, Date date, Status status, List<Player> players, String type, Cancha cancha, List<Category> categories) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.players = players;
        this.type = type;
        this.cancha = cancha;
        this.categories = categories;
    }


    public Event(EventDTO event) {
        this.type = event.getType();
        this.date = event.getDate();
        this.status = event.getStatus();
        this.cancha = event.getCancha() != null ? new Cancha(event.getCancha()) : null;
        this.players = event.getPlayers() != null ? event.getPlayers().stream().filter(p -> p != null).map(Player::new).collect(Collectors.toList()) : new ArrayList<>();
        this.categories = event.getCategories() != null ? event.getCategories().stream().filter(c -> c != null).map(Category::new).collect(Collectors.toList()) : new ArrayList<>();
    }

    @JsonProperty("categories")
    public List<Long> getCategoryIds() {
        return categories.stream()
                .map(Category::getId)  // Solo devolver el ID
                .collect(Collectors.toList());
    }

    @JsonProperty("players")
    public List<Long> getPlayerIds() {
        return players.stream()
                .map(Player::getId)  // Solo devolver el ID
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }
}