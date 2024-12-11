package org.siit.projects.jdbcBookingApp.service;

import org.siit.projects.jdbcBookingApp.model.AccommodationRoomFareRelation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccommodationRoomFareRelationService {

    public static final String RELATION_TABLE_SELECT = "SELECT accommodation.type, accommodation.bed_type, room_fare.value_eur, room_fare.season\n" +
            "FROM accommodation\n" +
            "JOIN accommodation_room_fare_relation \n" +
            "ON accommodation.id=accommodation_room_fare_relation.accommodation_id\n" +
            "JOIN room_fare \n" +
            "ON accommodation_room_fare_relation.room_fare_id=room_fare.id";

    public static void insertAccommodationWithFare(Connection connection, int id, int accommodationId, int fareId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accommodation_room_fare_relation VALUES(?, ?, ?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, accommodationId);
            preparedStatement.setInt(3, fareId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<AccommodationRoomFareRelation> selectRoomWithPrice(Connection connection) {
        List<AccommodationRoomFareRelation> roomWithPriceList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT accommodation.type, " +
                "accommodation.bed_type, room_fare.value_eur, room_fare.season\n" +
                "FROM accommodation\n" +
                "JOIN accommodation_room_fare_relation \n" +
                "ON accommodation.id=accommodation_room_fare_relation.accommodation_id\n" +
                "JOIN room_fare \n" +
                "ON accommodation_room_fare_relation.room_fare_id=room_fare.id");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                AccommodationRoomFareRelation room = AccommodationRoomFareRelation.builder()
                        .roomType(resultSet.getString("accommodation.type"))
                        .roomBedType(resultSet.getString("accommodation.bed_type"))
                        .roomPrice(resultSet.getDouble("room_fare.value"))
                        .roomPriceSeason(resultSet.getString("room_fare.season"))
                        .build();
                roomWithPriceList.add(room);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return roomWithPriceList;
    }


}
