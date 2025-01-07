package com.project.models.entitys;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.models.dtos.CoachDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "coach")
@Data
@NoArgsConstructor
public class Coach extends User {


    private Long id;
    // Relación Muchos a Muchos con Category
    @ManyToMany
    @JoinTable(
            name = "coach_category",  // Tabla intermedia
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonManagedReference
    private List<Category> categories = new ArrayList<>();


    public Coach(CoachDTO coachDTO) {
        if (coachDTO.getCategories() != null) {
            List<Category> categorias = coachDTO.getCategories().stream()
                    .map(categoryDTO -> new Category(categoryDTO.getId(), categoryDTO.getName(), categoryDTO.getYear(), categoryDTO.getGender()))
                    .collect(Collectors.toList());
            this.setCategories(categorias);
        }
        this.setName(coachDTO.getName());
        this.setLastName(coachDTO.getLastName());
        this.setEmail(coachDTO.getMail());
        this.setUserName(coachDTO.getUserName());
        this.setPhone(coachDTO.getPhone());
        this.setPassword(coachDTO.getPassword());

    }
}
