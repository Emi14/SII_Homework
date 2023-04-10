package org.siit.projects.skiBiathlonStandings;

import org.siit.projects.skiBiathlonStandings.service.IService;
import org.siit.projects.skiBiathlonStandings.service.ServiceImpl;

public class Main {
    private static final IService service = new ServiceImpl();
    public static void main(String[] args) {
        String fileName = "src/main/resources/resultsIO.csv";
        for(int i = 0; i < 3; i++) {
            System.out.println(service.writeResults().get(i) + service.determineStandings(fileName).get(i));
        }
    }
}
