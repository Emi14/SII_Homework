package org.siit.homework.week11.service;

import org.siit.homework.week11.bookingApp.Accomodation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccomodationService {

    public static final String ACCOMMODATION_INSERT = "INSERT INTO accommodation VALUES(?, ?, ?, ?, ?)";
    public static final String ACCOMMODATION_SELECT_ALL = "SELECT * FROM accommodation";
    public static final String ACCOMMODATION_SELECT_BY_ID = "SELECT * FROM accommodation WHERE id=?";
    public static final String ACCOMMODATION_DELETE = "DELETE FROM accommodation WHERE id=?";

    public static void insertAccommodation(Connection connection, int id, String type,
                                           String bedType, int maxGuests, String description) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOMMODATION_INSERT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, bedType);
            preparedStatement.setInt(4, maxGuests);
            preparedStatement.setString(5, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Accomodation> selectAllAccommodations(Connection connection) {
        List<Accomodation> accommodationList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOMMODATION_SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Accomodation accommodation = Accomodation.builder()
                        .id(resultSet.getInt("id"))
                        .type(resultSet.getString("type"))
                        .bed_type(resultSet.getString("bed_type"))
                        .maxGuests(resultSet.getInt("max_guests"))
                        .description(resultSet.getString("description"))
                        .build();
                accommodationList.add(accommodation);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return accommodationList;
    }

    public static Accomodation selectAccommodationById(Connection connection, int id) {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOMMODATION_SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Accomodation.builder()
                        .id(resultSet.getInt("id"))
                        .type(resultSet.getString("type"))
                        .bed_type(resultSet.getString("bed_type"))
                        .maxGuests(resultSet.getInt("max_guests"))
                        .description(resultSet.getString("description"))
                        .build();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }

    public static void deleteAccommodation(Connection connection, int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOMMODATION_DELETE)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
