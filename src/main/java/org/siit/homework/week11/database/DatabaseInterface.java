package org.siit.homework.week11.database;

import org.siit.homework.week11.model.Accomodation;
import org.siit.homework.week11.model.RoomFare;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface DatabaseInterface {
    String URL = "jdbc:postgresql://localhost:5432/bookings?user=postgres&password=postgres";
    void initializeJDBCDriver();
    Optional<Connection> getJDBCConnection();
    List<Accomodation> selectAllAccomodations(Connection connection);
    List<RoomFare> selectAllRoomFares(Connection connection);
    void addAccomodation(Connection connection, int accommodationId, String type, String bedType, int people, String description, int fareID, double valueEur, String season);
    List<Accomodation> selectAccomodationsWithFares(Connection connection);
    void updateAccommodation(int id, String type, String bedType, int maxGuests, String description);
}
