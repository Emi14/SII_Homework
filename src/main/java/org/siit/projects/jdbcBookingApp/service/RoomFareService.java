package org.siit.projects.jdbcBookingApp.service;

import org.siit.projects.jdbcBookingApp.model.RoomFare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomFareService {

    public static void insertRoomFare(Connection connection, int id, double value, String season) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO room_fare values(?, ?, ?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setDouble(2, value);
            preparedStatement.setString(3, season);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<RoomFare> selectAllRoomFares(Connection connection) {
        List<RoomFare> roomFareList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room_fare");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                RoomFare roomFare = RoomFare.builder()
                        .id(resultSet.getInt("id"))
                        .value(resultSet.getDouble("value"))
                        .season(resultSet.getString("season"))
                        .build();
                roomFareList.add(roomFare);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return roomFareList;
    }

    public static RoomFare selectRoomFareById(Connection connection, int id) {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room_fare WHERE id=?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return RoomFare.builder()
                        .id(resultSet.getInt("id"))
                        .value(resultSet.getDouble("value"))
                        .season(resultSet.getString("season"))
                        .build();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }

    public static void deleteRoomFare(Connection connection, int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM room_fare WHERE id=?")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
