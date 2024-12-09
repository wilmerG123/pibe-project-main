package com.project.repository;

import com.project.models.entitys.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

    // Este método no es directo porque no podemos referirnos a propiedades de una relación muchos a muchos de forma simple
    List<Coach> findByCategoriesId(Long categoryId);

    // Buscar coaches por el nombre (sin importar mayúsculas/minúsculas)
    List<Coach> findByNameIgnoreCase(String name);

}
