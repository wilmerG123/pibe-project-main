package com.project.repository;

import com.project.models.entitys.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanchasRepository extends JpaRepository<Cancha, Long> {
}
