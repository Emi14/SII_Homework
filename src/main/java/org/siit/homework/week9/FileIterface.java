package org.siit.homework.week9;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public interface FileIterface
{
    void readFromFile(File reader);
    void writeInFile(FileWriter writer);
}
