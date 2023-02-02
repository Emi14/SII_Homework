package org.siit.homework.week11.test.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTest {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            // Use a data model to store the results of the query
            List<RoomPrice> roomPrices = new ArrayList<>();

            // Execute a query to join the tables and retrieve the data
            String sql = "SELECT a.type, rf.value " +
                    "FROM accommodation a " +
                    "JOIN accommodation_room_fare_relation arfr ON a.id = arfr.accommodation_id " +
                    "JOIN room_fare rf ON arfr.room_fare_id = rf.id";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                // Process the result set and add the data to the data model
                while (resultSet.next()) {
                    String roomType = resultSet.getString("type");
                    double roomPrice = resultSet.getDouble("value");
                    roomPrices.add(new RoomPrice(roomType, roomPrice));
                }
            }

            // Print out the prices for each room
            for (RoomPrice roomPrice : roomPrices) {
                System.out.println("Room Type: " + roomPrice.roomType + ", Price: " + roomPrice.roomPrice);
            }

        } catch (SQLException e) {
            System.err.println("An error occurred while querying the database: " + e.getMessage());
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

    private static class RoomPrice {
        private String roomType;
        private double roomPrice;

        public RoomPrice(String roomType, double roomPrice) {
            this.roomType = roomType;
            this.roomPrice = roomPrice;
        }
    }
}