package org.siit.homework.week8.service;

import org.siit.homework.week8.model.Athlete;

import java.util.List;

public interface IService {

    List<Athlete> determineStandings(String fileName);
    List<String> writeResults();
}
