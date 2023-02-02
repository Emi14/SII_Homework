package org.siit.homework.week11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingApplication {

    public static void main(String[] args) throws SQLException {
        // create connection
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

        // create tables
        String createAccommodationTable = "CREATE TABLE IF NOT EXISTS accommodation (id int primary key, type varchar(32), bed_type varchar(32), max_guests int, description varchar(512))";
        String createRoomFareTable = "CREATE TABLE IF NOT EXISTS room_fare (id int primary key, value double, season varchar(32))";
        String createAccommodationRoomFareRelationTable = "CREATE TABLE IF NOT EXISTS accommodation_room_fare_relation (id int primary key, accommodation_id int, room_fare_id int, FOREIGN KEY (accommodation_id) REFERENCES accommodation(id), FOREIGN KEY (room_fare_id) REFERENCES room_fare(id))";

        PreparedStatement ps = conn.prepareStatement(createAccommodationTable);
        ps.executeUpdate();

        ps = conn.prepareStatement(createRoomFareTable);
        ps.executeUpdate();

        ps = conn.prepareStatement(createAccommodationRoomFareRelationTable);
        ps.executeUpdate();

        // insert data
        String insertAccommodation = "INSERT INTO accommodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)";
        String insertRoomFare = "INSERT INTO room_fare (id, value, season) VALUES (?, ?, ?)";
        String insertAccommodationRoomFareRelation = "INSERT INTO accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (?, ?, ?)";

        ps = conn.prepareStatement(insertAccommodation);
        ps.setInt(1, 1);
        ps.setString(2, "Standard");
        ps.setString(3, "Double");
        ps.setInt(4, 2);
        ps.setString(5, "This is a standard room with a double bed for 2 guests");
        ps.executeUpdate();

        ps = conn.prepareStatement(insertRoomFare);
        ps.setInt(1, 1);
        ps.setDouble(2, 99.99);
        ps.setString(3, "Low");
        ps.executeUpdate();

        ps = conn.prepareStatement(insertAccommodationRoomFareRelation);
        ps.setInt(1, 1);
        ps.setInt(2, 1);
        ps.setInt(3, 1);
        ps.executeUpdate();

        // close connection
        conn.close();
    }
}
