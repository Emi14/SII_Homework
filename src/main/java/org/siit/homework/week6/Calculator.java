package org.siit.homework.week6;

public class Calculator
{
    int km;
    int m;
    int dm;
    int cm;
    int mm;
    int number;
    String type;
    int answer;
    String answerType;

    public void add(int number, String type)
    {
        this.number = number;
        this.type = type;
        switch (type) {
            case "mm":
                mm += number;
                break;
            case "cm":
                cm += number;
                break;
            case "dm":
                dm += number;
                break;
            case "m":
                m += number;
                break;
            case "km":
                km += number;
                break;
        }
    }

    public void sub(int number, String type)
    {
        this.number = number;
        this.type = type;
        switch (type) {
            case "mm":
                mm -= number;
                break;
            case "cm":
                cm -= number;
                break;
            case "dm":
                dm -= number;
                break;
            case "m":
                m -= number;
                break;
            case "km":
                km -= number;
                break;
        }
    }

    public int getResult()
    {
        return mm + cm*10 + dm*100 + m*1000 + km*1000000;
    }
    public  void expresion(String string)
    {
        String[] stringArray = string.split(" ");
        add(Integer.parseInt(stringArray[0]), stringArray[1]);
        for(int i = 2; i < stringArray.length; i += 3)
        {
            if (stringArray[i].equals("+"))
            {
                add(Integer.parseInt(stringArray[i+1]), stringArray[i+2]);
            }
            else if(stringArray[i].equals("-"))
            {
                sub(Integer.parseInt(stringArray[i+1]), stringArray[i+2]);
            }
            if (stringArray[i].equals("="))
            {
                answer = Integer.parseInt(stringArray[i+1]);
                answerType = stringArray[i+2];
                i = stringArray.length-1;
            }
        }

    }

    public int getAnswer() {
        return answer;
    }

}
