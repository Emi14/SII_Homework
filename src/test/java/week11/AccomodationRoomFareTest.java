package week11;

import org.junit.jupiter.api.*;
import org.siit.homework.week11.database.Database;
import org.siit.homework.week11.database.DatabaseInterface;
import org.siit.homework.week11.model.Accomodation;
import org.siit.homework.week11.model.RoomFare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccomodationRoomFareTest {

    private final DatabaseInterface databaseInterface = new Database();

    private static Connection dbConnection;

    @BeforeAll
    public static void setup() throws SQLException {
        org.h2.tools.Server.createWebServer().start();
    }

    @BeforeEach
    public void refreshConnection() throws SQLException {
        dbConnection = DriverManager.getConnection("jdbc:h2:mem:testcase", "sa", "");
    }

    @AfterAll
    public static void cleanUp() throws SQLException {
        dbConnection.close();
    }

    @Test
    @Order(1)
    public void createData() throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS accomodation\n" +
                "(\n" +
                "    id bigint NOT NULL,\n" +
                "    type character varying(32) NOT NULL,\n" +
                "    bed_type character varying(32) NOT NULL,\n" +
                "    max_guests bigint NOT NULL,\n" +
                "    description character varying(512) NOT NULL,\n" +
                "    CONSTRAINT accomodation_pkey PRIMARY KEY (id)\n" +
                ")");
        preparedStatement.execute();
        preparedStatement = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS room_fare\n" +
                "(\n" +
                "    id bigint NOT NULL,\n" +
                "    value double precision NOT NULL,\n" +
                "    season character varying(32) NOT NULL,\n" +
                "    CONSTRAINT room_fare_pkey PRIMARY KEY (id)\n" +
                ")");
        preparedStatement.execute();
        preparedStatement = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS accomodation_room_fare_relation\n" +
                "(\n" +
                "    id bigint NOT NULL,\n" +
                "    accomodation_id bigint NOT NULL,\n" +
                "    room_fare_id bigint NOT NULL,\n" +
                "    CONSTRAINT accomodation_room_fare_relation_pkey PRIMARY KEY (id)\n" +
                ")");
        preparedStatement.execute();

        preparedStatement = dbConnection.prepareStatement(
                "INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (4, 'double', 'double bed', 2, 'Sleeps 2 people, floor-to-ceiling windows, mini-fridge,  50-inch HDTV. Floor-to-ceiling windows. Work in comfort at the desk with ergonomic chair, stay connected with WiFi (fees apply). Make coffee and tea right in your room. Additional features include a safe, mini-fridge, iron and ironing board. These rooms have air conditioning. Refresh in the bathroom with a range of toiletries.');\n" +
                        "INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (3, 'double', 'double bed', 2, 'Sleeps 2 people, floor-to-ceiling windows, mini-fridge,  50-inch HDTV. Floor-to-ceiling windows. Work in comfort at the desk with ergonomic chair, stay connected with WiFi (fees apply). Make coffee and tea right in your room. Additional features include a safe, mini-fridge, iron and ironing board. These rooms have air conditioning. Refresh in the bathroom with a range of toiletries.');\n" +
                        "INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (1, 'single', 'single bed', 1, 'Floor-to-ceiling windows, WiFi, LCD TV, mini-fridge. This room has one single bed and an elegant bathroom with exclusive bath products.');\n" +
                        "INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (2, 'single', 'single bed', 1, 'Floor-to-ceiling windows, WiFi, LCD TV, mini-fridge. This room has one single bed and an elegant bathroom with exclusive bath products.');\n" +
                        "INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (6, 'quad', 'two double beds', 4, 'Perfect for children. Sleeps 4 people. Floor-to-ceiling windows, WiFi, LCD TV, mini-fridge. This room has two double beds and an elegant bathroom with exclusive bath products. ');\n" +
                        "INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (7, 'king', 'king bed', 2, 'Our stylish guest room features floor-to-ceiling windows. Work in comfort at the desk with chair, stay connected with WiFi (fees apply) or unwind and watch your favorite channel or TV show on our 50-inch LCD TV. Make coffee and tea right in your room. This room has a king size bed.\n" +
                        "This room has air conditioning and an elegant bathroom with exclusive bath products. Sleeps 2.');\n" +
                        "INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (5, 'twin', 'twin beds', 2, 'Bathrobe, slippers, complimentary water, floor-to-ceiling windows, WiFi.\n" +
                        "Unwind in this contemporary and spacious, deluxe room with floor-to-ceiling windows. \n" +
                        "Catch up on work at the desk, stay connected with WiFi (fees apply), or watch your favorite channel or TV show on our 50-inch LCD TV. Additional features include mini-fridge, and MP3 alarm clock.\n" +
                        "This room has two twin beds and an elegant bathroom with exclusive bath products. Sleeps 2 adults or children');" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (14, 7, 8);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (13, 7, 7);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (12, 6, 6);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (11, 6, 5);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (10, 5, 4);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (9, 5, 3);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (8, 4, 4);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (7, 4, 3);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (6, 3, 4);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (5, 3, 3);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (4, 2, 2);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (3, 2, 1);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (2, 1, 2);\n" +
                        "INSERT INTO accomodation_room_fare_relation (id, accomodation_id, room_fare_id) VALUES (1, 1, 1);" +
                        "INSERT INTO room_fare (id, value_eur, season) VALUES (8, 300, 'summer');\n" +
                        "INSERT INTO room_fare (id, value_eur, season) VALUES (7, 150, 'winter');\n" +
                        "INSERT INTO room_fare (id, value_eur, season) VALUES (6, 250, 'summer');\n" +
                        "INSERT INTO room_fare (id, value_eur, season) VALUES (5, 125, 'winter');\n" +
                        "INSERT INTO room_fare (id, value_eur, season) VALUES (4, 200, 'summer');\n" +
                        "INSERT INTO room_fare (id, value_eur, season) VALUES (3, 100, 'winter');\n" +
                        "INSERT INTO room_fare (id, value_eur, season) VALUES (2, 150, 'summer');\n" +
                        "INSERT INTO room_fare (id, value_eur, season) VALUES (1, 75, 'winter');");

        preparedStatement.execute();


    }

    // insert accomodation in DB
    @Test
    @Order(2)
    public void insertData() {
        databaseInterface.addAccomodation(dbConnection, 8, "single", "single bed", 1, "nice room", 9, 185, "winter");
    }

    // select all accomodations
    @Test
    @Order(3)
    public void selectAllaccomodations() {
        System.out.println("\n\n" + databaseInterface.selectAllAccomodations(dbConnection));
    }

    // select all fares
    @Test
    @Order(4)
    public void selectAllFares() {
        System.out.println("\n\n" + databaseInterface.selectAllRoomFares(dbConnection));
    }

    // select all accomodations with fares
    @Test
    @Order(5)
    public void selectAllaccomodationsWithFares() {
        System.out.println("\n\n");
        List<Accomodation> results = databaseInterface.selectAccomodationsWithFares(dbConnection);

        for (Accomodation a : results) {
            System.out.print("id = " + a.getId() + ", type = " + a.getType() + ", price: ");
            for (RoomFare f : a.getFares()) {
                System.out.print(" --" + f.getValue() + " " + f.getSeason() + "--  ");
            }
            System.out.println();
        }
    }
}
