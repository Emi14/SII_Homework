package org.siit.projects.jdbcBookingApp;

import org.siit.projects.jdbcBookingApp.model.Accommodation;
import org.siit.projects.jdbcBookingApp.service.AccommodationService;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        initializeJDBCDriver();
        Optional<Connection> connection = getJDBCConnection();
        if (!connection.isPresent()) {
            return;
        }

        List<Accommodation> accommodations = AccommodationService.selectAllAccommodations(connection.get());

    }

    private static void initializeJDBCDriver() {
        try {
            Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static Optional<Connection> getJDBCConnection() {
        try {
            return Optional.ofNullable(DriverManager.getConnection("jdbc:h2:mem:homework_db", "sa", ""));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

}
