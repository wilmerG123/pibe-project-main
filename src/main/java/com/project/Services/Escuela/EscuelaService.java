package com.project.Services.Escuela;

import com.project.models.entitys.Escuela;

import java.util.List;

public interface EscuelaService {

    public Escuela createEscuela(Escuela escuela);

    public Escuela editEscuela(Escuela escuela, Long id);

    public Escuela getEscuelaById(Long id);

    public List<Escuela> getAllEscuela();

    public void deleteEscuela(Long id);
}
