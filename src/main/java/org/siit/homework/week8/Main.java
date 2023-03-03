package org.siit.homework.week8;

import org.siit.homework.week8.service.IService;
import org.siit.homework.week8.service.ServiceImpl;

public class Main {
    private static final IService service = new ServiceImpl();
    public static void main(String[] args) {
        String fileName = "src/main/resources/resultsIO.csv";
        for(int i = 0; i < 3; i++) {
            System.out.println(service.writeResults().get(i) + service.determineStandings(fileName).get(i));
        }
    }
}
