package org.siit.homework.week11;

import org.siit.homework.week11.model.Accommodation;
import org.siit.homework.week11.model.Fare;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        initializeJDBCDriver();
        Optional<Connection> connectionOptional = getJDBCConnection();
        if (!connectionOptional.isPresent()) {
            return;
        }

        List<Accommodation> accommodation = selectAllAccommodations(connectionOptional.get());
        System.out.println(accommodation);
        connectionOptional = getJDBCConnection();
        if (!connectionOptional.isPresent()) {
            return;
        }

        List<Fare> fare = selectAllRoomFares(connectionOptional.get());
        System.out.println(fare);
        connectionOptional = getJDBCConnection();
        if (!connectionOptional.isPresent()) {
            return;
        }

        List<Accommodation> results = selectAccommodationsWithFares(connectionOptional.get());
        for (Accommodation a : results) {
            System.out.print("id = " + a.getId() + ", type = " + a.getType() + ", price: ");
            for (Fare f : a.getFares()) {
                System.out.print(" --" + f.getValueEUR() + " " + f.getSeason() + "--  ");
            }
            System.out.println();
        }

//        addAccommodationAndFareWithConnection(connectionOptional.get(), 8, "single", "single bed", 1, "nice room", 9, 185, "winter");
//        updateAccommodation(2, "triple", "3 twin beds", 3, "triple room");

    }

    private static void updateAccommodation(int id, String type, String bedType, int people, String description) {
        Optional<Connection> optionalConnection = getJDBCConnection();
        if (!optionalConnection.isPresent()) {
            return;
        }
        try (Connection connection = optionalConnection.get();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into accommodation values(?, ?, ?,?,?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, bedType);
            preparedStatement.setInt(4, people);
            preparedStatement.setString(5, description);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void addAccommodationAndFareWithConnection(Connection connection, int accommodationId, String type, String bedType, int people, String description, int fareID, double valueEur, String season) {
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
                System.err.println(ex.getMessage());
                connection.rollback();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Fare> selectAllRoomFares(Connection connection) {
        List<Fare> toReturn = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from room_fare");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Fare fare = new Fare(resultSet.getInt("id"),
                        resultSet.getDouble("value_eur"),
                        resultSet.getString("season"));
                toReturn.add(fare);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException e) {
            }
            if (preparedStatement != null) try {
                preparedStatement.close();
            } catch (SQLException e) {
            }
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        return toReturn;
    }

    public static List<Accommodation> selectAllAccommodations(Connection connection) {
        List<Accommodation> toReturn = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from accommodation");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Accommodation accommodation = new Accommodation(resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("bed_type"),
                        resultSet.getInt("max_guests"),
                        resultSet.getString("description"));
                toReturn.add(accommodation);
            }
//            resultSet = statement.executeQuery("update accommodation set type='king' where id =7");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException e) {
            }
            if (preparedStatement != null) try {
                preparedStatement.close();
            } catch (SQLException e) {
            }
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        return toReturn;
    }

    public static List<Accommodation> selectAccommodationsWithFares(Connection connection) {
        List<Accommodation> toReturn = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select accommodation.id, accommodation.type, room_fare.value_eur, room_fare.season\n" +
                    "from accommodation\n" +
                    "join accommodation_room_fare_relation \n" +
                    "on accommodation.id=accommodation_room_fare_relation.accommodation_id\n" +
                    "join room_fare \n" +
                    "on accommodation_room_fare_relation.room_fare_id=room_fare.id");
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                int accommodationIdFromResultSet = resultSet.getInt("id");
                Accommodation accommodation = null;

                for (Accommodation a : toReturn) {
                    if (a.getId() == accommodationIdFromResultSet) {
                        accommodation = a;
                        break;
                    }
                }

                if (accommodation == null) {
                    accommodation = new Accommodation(resultSet.getInt("id"), resultSet.getString("type"));
                    toReturn.add(accommodation);
                }

                Fare fare = new Fare(resultSet.getDouble("value_eur"), resultSet.getString("season"));
                accommodation.getFares().add(fare);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException e) {
            }
            if (preparedStatement != null) try {
                preparedStatement.close();
            } catch (SQLException e) {
            }
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        return toReturn;
    }

    private static void initializeJDBCDriver() {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException |
                 InvocationTargetException e) {
            System.err.println(e.getMessage());
        }
    }

    private static Optional<Connection> getJDBCConnection() {
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: database may be busy, good to set a higher timeout
        try {
            String url = "jdbc:postgresql://localhost:5432/Week11-homework?user=postgres&password=admin";
            return Optional.ofNullable(DriverManager.getConnection(url));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

}
