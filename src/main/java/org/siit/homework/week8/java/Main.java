package org.siit.homework.week8.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        File file= new File("src/main/resources/file.csv");

        Scanner sc = new Scanner(file);

        List<Atlet> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] elements = line.split(",");

            int numar = Integer.parseInt(elements[0]);
            String nume = elements[1];
            String codTara = elements[2];
                //30:10
            String[] timeElements = elements[3].split(":");
            int minut = Integer.parseInt(timeElements[0]);
            int secunda = Integer.parseInt(timeElements[1]);
            Time timp = new Time(minut,secunda);
            String primaAruncare = elements[4];
            String aDouaAruncare = elements[5];
            String aTreiaAruncare = elements[6];

            Atlet atlet = new Atlet(numar,nume,codTara,timp,primaAruncare,aDouaAruncare,aTreiaAruncare);

            int penalizare=0;
            for (int i = 0; i < primaAruncare.length(); i++) {
                    if(primaAruncare.charAt(i)=='o')
                        penalizare+=10;
            }

            for (int i = 0; i < aDouaAruncare.length(); i++) {
                if(aDouaAruncare.charAt(i)=='o')
                    penalizare+=10;
            }

            for (int i = 0; i < aTreiaAruncare.length(); i++) {
                if(aTreiaAruncare.charAt(i)=='o')
                    penalizare+=10;
            }

            atlet.setPenalizare(penalizare);
            Time timpFinal = new Time(atlet.getTimp().getMinut(),atlet.getTimp().getSecunda());
            timpFinal.aduna(penalizare);
            atlet.setTimpFinal(timpFinal);

            list.add(atlet);
        }

        list.sort(new Comparator<Atlet>() {
            @Override
            public int compare(Atlet o1, Atlet o2) {
                return o1.getTimpFinal().compare(o2.getTimpFinal());
            }
        });


        Level level;

        Atlet winner = list.get(0);
        winner.setLevel(Level.WINNER);
        Atlet runnerUp = list.get(1);
        runnerUp.setLevel(Level.RUNNERUP);
        Atlet thirdPlace = list.get(2);
        thirdPlace.setLevel(Level.THIRDPLACE);


//        winner.print("Winner");
//        runnerUp.print("Runner-up");
//        thirdPlace.print("Third Place");





    }
}