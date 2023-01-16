package week9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week9.FileIterface;
import org.siit.homework.week9.FileService;
import org.siit.homework.week9.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTest
{
    private final FileIterface file = new FileService();
    File reader = new File("./Person.In.txt");
    FileWriter writer;

    {
        try {
            writer = new FileWriter("Person.Out.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void readFromFile ()
    {
        file.readFromFile(reader);
    }

    @Test
    public void test_WriterValue()
    {

        file.writeInFile(writer);

    }
}
