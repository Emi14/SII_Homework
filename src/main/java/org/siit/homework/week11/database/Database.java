package org.siit.homework.week11.database;

import org.siit.homework.week11.model.Accomodation;
import org.siit.homework.week11.model.RoomFare;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database implements DatabaseInterface {

    @Override
    public void initializeJDBCDriver() {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Connection> getJDBCConnection() {
        DriverManager.setLoginTimeout(60);
        try {
            return Optional.ofNullable(DriverManager.getConnection(URL));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Accomodation> selectAllAccomodations(Connection connection) {
        List<Accomodation> accomodationList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from accomodation");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Accomodation accommodation = new Accomodation(resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("bed_type"),
                        resultSet.getInt("max_guests"),
                        resultSet.getString("description"));
                accomodationList.add(accommodation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accomodationList;
    }

    @Override
    public List<RoomFare> selectAllRoomFares(Connection connection) {
        List<RoomFare> roomFareList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from room_fare");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                RoomFare fare = new RoomFare(resultSet.getInt("id"),
                        resultSet.getDouble("value"),
                        resultSet.getString("season"));
                roomFareList.add(fare);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomFareList;
    }

    @Override
    public void addAccomodation(Connection connection, int accommodationId, String type, String bedType, int people, String description, int fareID, double valueEur, String season) {
        try {
            try (PreparedStatement accommodationInsert = connection.prepareStatement("insert into accommodation values(?, ?, ?,?,?)");
                 PreparedStatement fareInsert = connection.prepareStatement("insert into room_fare values(?, ?, ?)")) {

                accommodationInsert.setInt(1, accommodationId);
                accommodationInsert.setString(2, type);
                accommodationInsert.setString(3, bedType);
                accommodationInsert.setInt(4, people);
                accommodationInsert.setString(5, description);


                fareInsert.setInt(1, fareID);
                fareInsert.setDouble(2, valueEur);
                fareInsert.setString(3, season);

                connection.setAutoCommit(false);
                accommodationInsert.executeUpdate();
                fareInsert.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Accomodation> selectAccomodationsWithFares(Connection connection) {
        List<Accomodation> accomodationListWithFares = new ArrayList<>();
        String query = """
                select accomodation.id, accomodation.type, room_fare.value, room_fare.season
                from accomodation
                join accomodation_room_fare_relation\s
                on accomodation.id=accomodation_room_fare_relation.accomodation_id
                join room_fare\s
                on accomodation_room_fare_relation.room_fare_id=room_fare.id""";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int accommodationIdFromResultSet = resultSet.getInt("id");
                Accomodation accomodation = null;
                for (Accomodation a : accomodationListWithFares) {
                    if (a.getId() == accommodationIdFromResultSet) {
                        accomodation = a;
                        break;
                    }
                }
                if (accomodation == null) {
                    accomodation = new Accomodation(resultSet.getInt("id"), resultSet.getString("type"));
                    accomodationListWithFares.add(accomodation);
                }
                RoomFare fare = new RoomFare(resultSet.getDouble("value"), resultSet.getString("season"));
                accomodation.getFares().add(fare);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accomodationListWithFares;
    }

    @Override
    public void updateAccommodation(int id, String type, String bedType, int maxGuests, String description) {
        Optional<Connection> optionalConnection = getJDBCConnection();
        if (optionalConnection.isEmpty()) {
            return;
        }
        try (Connection connection = optionalConnection.get();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into accommodation values(?, ?, ?,?,?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, bedType);
            preparedStatement.setInt(4, maxGuests);
            preparedStatement.setString(5, description);
            System.out.println("Affected rows: " + preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
