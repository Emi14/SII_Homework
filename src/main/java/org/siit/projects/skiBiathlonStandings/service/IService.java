package org.siit.projects.skiBiathlonStandings.service;

import org.siit.projects.skiBiathlonStandings.model.Athlete;

import java.util.List;

public interface IService {

    List<Athlete> determineStandings(String fileName);
    List<String> writeResults();
}
