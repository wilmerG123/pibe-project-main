package com.project.Services.Escuela;

import com.project.models.entitys.Escuela;
import com.project.repository.EscuelaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscuelaServiceImpl implements EscuelaService {

    private EscuelaRepository escuelaRepository;

    public EscuelaServiceImpl(EscuelaRepository escuelaRepository) {
        this.escuelaRepository = escuelaRepository;
    }

    @Override
    public Escuela createEscuela(Escuela escuela) {
        return escuelaRepository.save(escuela);
    }

    @Override
    public Escuela editEscuela(Escuela escuela, Long id) {
        escuela.setId(id);
        return escuelaRepository.save(escuela);
    }

    @Override
    public Escuela getEscuelaById(Long id) {
        return escuelaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Escuela> getAllEscuela() {
        return escuelaRepository.findAll();
    }

    @Override
    public void deleteEscuela(Long id) {
        escuelaRepository.deleteById(id);
    }
}
