package com.project.Services.Coach;

import com.project.models.entitys.Coach;

import java.util.List;
import java.util.Set;

public interface CoachService {

    public Coach saveCoach(Coach coach);

    public Coach editCoach(Coach coach, Long id);

    public List<Coach> getAllCoach();
    public List<Coach> getAllCoachByCategory(Long id);
    public List<Coach> getCoachByName(String name);
    public void deleteById(Long id);
}
