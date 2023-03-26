package org.siit.homework.week11;

import org.siit.homework.week11.database.Database;
import org.siit.homework.week11.database.DatabaseInterface;
import org.siit.homework.week11.model.Accomodation;
import org.siit.homework.week11.model.RoomFare;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        DatabaseInterface database = new Database();
        database.initializeJDBCDriver();
        Optional<Connection> connectionOptional = database.getJDBCConnection();
        if (connectionOptional.isEmpty()) {
            return;
        }
        database.selectAllAccomodations(connectionOptional.get()).forEach(System.out::println);
        System.out.println();
        connectionOptional = database.getJDBCConnection();
        if (connectionOptional.isEmpty()) {
            return;
        }
        database.selectAllRoomFares(connectionOptional.get()).forEach(System.out::println);
        System.out.println();
        List<Accomodation> results = database.selectAccomodationsWithFares(connectionOptional.get());
        for (Accomodation accomodation : results) {
            System.out.print("id = " + accomodation.getId() + ", type = " + accomodation.getType() + ", price: ");
            for (RoomFare fare : accomodation.getFares()) {
                System.out.print(" --" + fare.getValue() + " " + fare.getSeason() + "--  ");
            }
            System.out.println();
        }
    }
}
