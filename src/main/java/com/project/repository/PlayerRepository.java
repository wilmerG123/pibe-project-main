package com.project.repository;

import com.project.models.entitys.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    // Buscar jugadores por el ID de la categoría
    List<Player> findByCategoryId(Long categoryId);
    // Buscar jugadores por el nombre (caso insensible)
    List<Player> findByNameIgnoreCase(String name);
    // Buscar jugadores asociados a un evento por el ID del evento
    List<Player> findByEventsId(Long eventId);

}
