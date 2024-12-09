package com.project.models.dtos;

import com.project.models.entitys.Cancha;
import com.project.models.enums.Status;

import java.util.Date;
import java.util.List;

public class EventDTO {

    private Long id;
    private String type;
    private Date date;
    private Status status;
    private CanchaDTO cancha;
    private List<PlayerDTO> players;
    private List<CategoryDTO> categories;

    public EventDTO() {
    }

    public EventDTO(Long id, String type, Date date, Status status, CanchaDTO cancha, List<PlayerDTO> players, List<CategoryDTO> categories) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.status = status;
        this.cancha = cancha;
        this.players = players;
        this.categories = categories;
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

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
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

    public CanchaDTO getCancha() {
        return cancha;
    }

    public void setCancha(CanchaDTO cancha) {
        this.cancha = cancha;
    }
}
