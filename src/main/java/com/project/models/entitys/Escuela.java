package com.project.models.entitys;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "escuelas")
@Data
@NoArgsConstructor
public class Escuela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    // Relación muchos a muchos con Jugador (escuelas pueden tener muchos jugadores)
    @ManyToMany
    @JoinTable(
            name = "escuela_jugador",
            joinColumns = @JoinColumn(name = "escuela_id"),
            inverseJoinColumns = @JoinColumn(name = "jugador_id")
    )
    private List<Player> players;
}
