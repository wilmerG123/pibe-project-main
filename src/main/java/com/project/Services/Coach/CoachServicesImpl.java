package com.project.Services.Coach;

import com.project.models.entitys.Coach;
import com.project.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServicesImpl implements CoachService{

    private CoachRepository coachRepository;

    public CoachServicesImpl(CoachRepository coachRepository){
        this.coachRepository = coachRepository;
    }
    @Override
    public Coach saveCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public Coach editCoach(Coach coach, Long id) {
        coach.setId(id);
        return coachRepository.save(coach);
    }

    @Override
    public List<Coach> getAllCoach() {
        return coachRepository.findAll();
    }

    @Override
    public List<Coach> getAllCoachByCategory(Long id) {
        return coachRepository.findByCategoriesId(id);
    }

    @Override
    public List<Coach> getCoachByName(String name) {
        return coachRepository.findByNameIgnoreCase(name);
    }

    @Override
    public void deleteById(Long id) {
        coachRepository.deleteById(id);
    }
}
