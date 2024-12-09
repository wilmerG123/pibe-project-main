package com.project.models.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.models.dtos.CategoryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String year;
    private String gender;

    // Relación Muchos a Muchos con Coach
    @ManyToMany(mappedBy = "categories")
    @JsonBackReference  // Evita la recursividad infinita en este lado
    private List<Coach> coaches;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference  // Evita la recursividad infinita en este lado
    private List<Event> events;


    public Category() {
    }

    public Category(CategoryDTO category) {
        this.id = category.getId();
        this.name = category.getName();
        this.year = category.getYear();
        this.gender = category.getGender();
    }

    public Category(Long id) {
        this.id = id;
    }

    public Category(Long id, String name, String year, String gender) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.gender = gender;
    }

    public Category(String name, String year, String gender) {
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.coaches = coaches;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
}
