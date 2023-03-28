package org.siit.homework.week11;

import java.sql.*;

public class BookingApplication {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Accommodation";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "IubisMeu12";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO accommodation (type, bed_type, max_guests, description) " +
                        "VALUES (?, ?, ?, ?);"
        );
        stmt.setString(1, "hotel room");
        stmt.setString(2, "double");
        stmt.setInt(3, 2);
        stmt.setString(4, "A cozy room with a comfortable double bed.");
        stmt.executeUpdate();

        stmt.setString(1, "apartment");
        stmt.setString(2, "queen");
        stmt.setInt(3, 4);
        stmt.setString(4, "A spacious apartment with a queen-sized bed and a sofa bed.");
        stmt.executeUpdate();

        stmt = conn.prepareStatement(
                "INSERT INTO room_fare (value, season) " +
                        "VALUES (?, ?);"
        );
        stmt.setDouble(1, 100.0);
        stmt.setString(2, "low");
        stmt.executeUpdate();

        stmt.setDouble(1, 150.0);
        stmt.setString(2, "high");
        stmt.executeUpdate();

        stmt = conn.prepareStatement(
                "INSERT INTO accommodation_room_fare_relation (accommodation_id, room_fare_id) " +
                        "VALUES (?, ?);"
        );
        stmt.setInt(1, 1);
        stmt.setInt(2, 1);
        stmt.executeUpdate();

        stmt.setInt(1, 2);
        stmt.setInt(2, 2);
        stmt.executeUpdate();

        stmt = conn.prepareStatement(
                "SELECT a.type, r.value " +
                        "FROM accommodation a " +
                        "JOIN accommodation_room_fare_relation ar ON a.id = ar.accommodation_id " +
                        "JOIN room_fare r ON ar.room_fare_id = r.id;"
        );
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String type = rs.getString("type");
            double value = rs.getDouble("value");
            System.out.println(type + " - " + value);
        }

        conn.close();
    }
}