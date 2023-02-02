package week11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseTest {

    public static void main(String[] args) throws SQLException {
        // create connection
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

        // query data
        String query = "SELECT a.type, rf.value FROM accommodation a JOIN accommodation_room_fare_relation arfr ON a.id = arfr.accommodation_id JOIN room_fare rf ON arfr.room_fare_id = rf.id";

        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        // print prices for each room
        while (rs.next()) {
            String type = rs.getString("type");
            double value = rs.getDouble("value");
            System.out.println(type + ": $" + value);
        }

        // close connection
        conn.close();
    }
}
