package org.siit.homework.week11;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/booking_db";
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    public void insertAccommodation(Accommodation accommodation) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO accommodation (id, type, bed_type, max_guests, description) " +
                        "VALUES (nextval('accommodation_id_seq'), ?, ?, ?, ?);"
        );
        stmt.setString(1, accommodation.getType());
        stmt.setString(2, accommodation.getBedType());
        stmt.setInt(3, accommodation.getMaxGuests());
        stmt.setString(4, accommodation.getDescription());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void insertRoomFare(RoomFare roomFare) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO room_fare (id, value, season) " +
                        "VALUES (nextval('room_fare_id_seq'), ?, ?);"
        );
        stmt.setDouble(1, roomFare.getValue());
        stmt.setString(2, roomFare.getSeason());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void insertAccommodationRoomFareRelation(int accommodationId, int roomFareId) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO accommodation_room_fare_relation (id, accommodation_id, room_fare_id) " +
                        "VALUES (nextval('accommodation_room_fare_relation_id_seq'), ?, ?);"
        );
        stmt.setInt(1, accommodationId);
        stmt.setInt(2, roomFareId);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<AccommodationRoomFare> getAccommodationRoomFares() throws SQLException {
        List<AccommodationRoomFare> accommodationRoomFares = new ArrayList<>();
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT a.id, a.type, r.value, r.season " +
                        "FROM accommodation a " +
                        "JOIN accommodation_room_fare_relation ar ON a.id = ar.accommodation_id " +
                        "JOIN room_fare r ON ar.room_fare_id = r.id;"
        );
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String type = rs.getString("type");
            double value = rs.getDouble("value");
            String season = rs.getString("season");
            AccommodationRoomFare accommodationRoomFare = new AccommodationRoomFare(id, type, value, season);
            accommodationRoomFares.add(accommodationRoomFare);
        }
        rs.close();
        stmt.close();
        conn.close();
        return accommodationRoomFares;
    }
}
