package com.project.repository;


import com.project.models.entitys.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Event, Long> {
    // Buscar eventos que contienen una categoría específica
    List<Event> findByCategoriesId(Long categoryId);
}
