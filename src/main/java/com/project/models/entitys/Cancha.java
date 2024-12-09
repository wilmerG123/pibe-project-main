package com.project.models.entitys;


import com.project.models.dtos.CanchaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cancha")
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Cancha(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cancha() {
    }

    public Cancha(CanchaDTO cancha) {
        this.id = cancha.getId();
        this.name = cancha.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
