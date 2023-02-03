package week11;

import org.siit.homework.week11.RoomFare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingAppUnitTest {
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    public static void main(String[] args) {
        // get the prices for each room in the database
        List<RoomFare> roomFares = getRoomFares();
        for (RoomFare roomFare : roomFares)
            System.out.println("Room price: " + roomFare.getValue() + " Season: " + roomFare.getSeason());
    }

    private static List<RoomFare> getRoomFares() {
        List<RoomFare> roomFares = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT rf.value, rf.season " +
                    "FROM room_fare rf " +
                    "JOIN accommodation_room_fare_relation arfr " +
                    "ON rf.id = arfr.room_fare_id " +
                    "JOIN accommodation a " +
                    "ON arfr.accommodation_id = a.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RoomFare roomFare = new RoomFare();
                roomFare.setValue(rs.getDouble("value"));
                roomFare.setSeason(rs.getString("season"));
                roomFares.add(roomFare);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomFares;
    }
}
