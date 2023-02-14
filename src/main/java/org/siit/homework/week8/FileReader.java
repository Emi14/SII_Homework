package org.siit.homework.week8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReader implements FileIterface
{

    List<Athlete> athleteList = new ArrayList<>();

    public void readFile (File reader)
    {
        try {
            Scanner myReader = new Scanner(reader);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] thisAthlete = (data.split(","));
                String[] timeString = thisAthlete[3].split(":");
                Integer hours =  Integer.parseInt(timeString[0]);
                Integer seconds =  Integer.parseInt(timeString[1]);
                athleteList.add(new Athlete(new Integer(thisAthlete[0]), thisAthlete[1], thisAthlete[2], hours, seconds, thisAthlete[4], thisAthlete[5], thisAthlete[6]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }



    public void winners()
    {
        for(Athlete athlete : this.athleteList)
        {
            int count = 0 ;

            char[] charFirstArray = athlete.FirstShootingRange.toCharArray();
            for(int i=1; i<charFirstArray.length; i++)
            {
                if(charFirstArray[i]=='o')
                {
                    count++;
                }
            }
            char[] charSecondArray = athlete.SecondShooting.toCharArray();
            for(int i=1; i<charFirstArray.length; i++)
            {
                if(charSecondArray[i]=='o')
                {
                    count++;
                }
            }
            char[] charThirdArray = athlete.ThirdShooting.toCharArray();
            for(int i=1; i<charFirstArray.length; i++)
            {
                if(charThirdArray[i]=='o')
                {
                    count++;
                }
            }

            int penalty = count * 10;
            int minutes = athlete.getMinutes();
            int seconds = athlete.getSeconds();

            if (penalty + seconds == 60)
            {
                minutes++;
                seconds = 0;

            }else if (penalty >= 60 - seconds)
            {
                seconds = penalty - (60 - seconds);
                minutes++;

            }else
            {
                seconds += penalty;
            }

            athlete.setMinutes(minutes);
            athlete.setSeconds(seconds);
            athlete.setOverallTime(minutes*60 + seconds);
            athlete.setPenalty(penalty);
        }


    }

    public void writeWinners ()
    {
        List<String> athleteWinners = athleteList.stream()
                .sorted(Comparator.comparingInt(Athlete::getOverallTime))
                .map(athlete -> {
                    return athlete.AthleteName +
                            " " + athlete.minutes +
                            ":" +
                            athlete.seconds +
                            " (" +
                            athlete.SkiTimeResult +
                            " + " +
                            athlete.penalty + ")";
                })
                .collect(Collectors.toList());

        System.out.println("Winner - " + athleteWinners.get(0));
        System.out.println("Runner-up - "+ athleteWinners.get(1));
        System.out.println("Third Place - "+ athleteWinners.get(2));

    }


}

