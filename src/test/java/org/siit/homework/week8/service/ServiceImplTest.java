package org.siit.homework.week8.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week8.model.Athlete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ServiceImplTest {

    ServiceImpl serviceImpl;
    List<Athlete> athleteList;

    @BeforeEach
    void setUp() {
        serviceImpl = new ServiceImpl();
        athleteList = new ArrayList<>();
    }


    @Test
    public void testGenerateCollection_whenFirstCommaIsMissing_theExceptionIsThrown() {
        String line = "1 Gica Franaru,RO 35:17,xxoxx,xxxxx,xxxxo";
        Scanner scanner = new Scanner(line);
        assertThrows(IllegalArgumentException.class,
                () -> serviceImpl.generateCollection(athleteList, scanner));
    }

    @Test
    public void testGenerateCollection_whenSecondCommaIsMissing_theExceptionIsThrown() {
        String line = "1,Gica Franaru RO 35:17,xxoxx,xxxxx,xxxxo";
        Scanner scanner = new Scanner(line);
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> serviceImpl.generateCollection(athleteList, scanner));
    }

    @Test
    public void testGenerateCollection_whenThereAreLessThanFiveShootingsPerSet_theExceptionIsThrown() throws IOException {
        String line = "1,Gica Franaru RO 35:17,xxoxx,xxxx,xxxxo";
        Scanner scanner = new Scanner(line);

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> serviceImpl.generateCollection(athleteList, scanner));
    }



}