package org.siit.homework.week11.java.org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Connect to the database
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            // Insert data into Accommodation table
            String sqlAccommodation = "INSERT INTO Accommodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sqlAccommodation)) {
                statement.setInt(1, 1);
                statement.setString(2, "Double Room");
                statement.setString(3, "King");
                statement.setInt(4, 2);
                statement.setString(5, "Spacious room with king-sized bed");
                int rowsAffected = statement.executeUpdate();
                System.out.println("Rows affected in Accommodation table: " + rowsAffected);
            }

            // Insert data into RoomFare table
            String sqlRoomFare = "INSERT INTO RoomFare (id, value, season) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sqlRoomFare)) {
                statement.setInt(1, 1);
                statement.setDouble(2, 100.0);
                statement.setString(3, "High Season");
                int rowsAffected = statement.executeUpdate();
                System.out.println("Rows affected in RoomFare table: " + rowsAffected);
            }

            // Insert data into AccommodationRoomFareRelation table
            String sqlAccommodationRoomFareRelation = "INSERT INTO AccommodationRoomFareRelation (id, accommodation_id, room_fare_id) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sqlAccommodationRoomFareRelation)) {
                statement.setInt(1, 1);
                statement.setInt(2, 1);
                statement.setInt(3, 1);
                int rowsAffected = statement.executeUpdate();
                System.out.println("Rows affected in AccommodationRoomFareRelation table: " + rowsAffected);
            }

        } catch (SQLException e) {
            System.err.println("An error occurred while connecting to the database: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC driver not found. " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("An error occurred while closing the connection: " + e.getMessage());
                }
            }
        }
    }
}
