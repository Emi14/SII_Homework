package week11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week11.Accommodation;
import org.siit.homework.week11.AccommodationRoomFare;
import org.siit.homework.week11.BookingDAO;
import org.siit.homework.week11.RoomFare;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class BookingApplicationTest {
    private static final String ACCOMMODATION_TYPE = "Apartment";
    private static final String ACCOMMODATION_BED_TYPE = "Queen";
    private static final int ACCOMMODATION_MAX_GUESTS = 4;
    private static final String ACCOMMODATION_DESCRIPTION = "Spacious apartment with beautiful view";
    private static final double ROOM_FARE_VALUE = 150.00;
    private static final String ROOM_FARE_SEASON = "Summer";

    private BookingDAO bookingDAO;

    @BeforeEach
    void setUp() {
        bookingDAO = new BookingDAO();
    }

    @Test
    void testInsertAccommodation() throws SQLException {
        Accommodation accommodation = new Accommodation(
                ACCOMMODATION_TYPE,
                ACCOMMODATION_BED_TYPE,
                ACCOMMODATION_MAX_GUESTS,
                ACCOMMODATION_DESCRIPTION
        );
        bookingDAO.insertAccommodation(accommodation);
        assertNotNull(accommodation.getId());
    }

    @Test
    void testInsertRoomFare() throws SQLException {
        RoomFare roomFare = new RoomFare(ROOM_FARE_VALUE, ROOM_FARE_SEASON);
        bookingDAO.insertRoomFare(roomFare);
        assertNotNull(roomFare.getId());
    }

    @Test
    void testInsertAccommodationRoomFareRelation() throws SQLException {
        Accommodation accommodation = new Accommodation(
                ACCOMMODATION_TYPE,
                ACCOMMODATION_BED_TYPE,
                ACCOMMODATION_MAX_GUESTS,
                ACCOMMODATION_DESCRIPTION
        );
        bookingDAO.insertAccommodation(accommodation);

        RoomFare roomFare = new RoomFare(ROOM_FARE_VALUE, ROOM_FARE_SEASON);
        bookingDAO.insertRoomFare(roomFare);

        AccommodationRoomFare accommodationRoomFare = new AccommodationRoomFare(
                accommodation.getId(),
                accommodation.getType(),
                roomFare.getValue(),
                roomFare.getSeason()
        );
        bookingDAO.insertAccommodationRoomFareRelation(accommodationRoomFare);

        List<AccommodationRoomFare> accommodationRoomFares = bookingDAO.getAccommodationRoomFares();
        assertTrue(accommodationRoomFares.size() > 0);
    }

    @Test
    void testGetAccommodationRoomFares() throws SQLException {
        Accommodation accommodation = new Accommodation(
                ACCOMMODATION_TYPE,
                ACCOMMODATION_BED_TYPE,
                ACCOMMODATION_MAX_GUESTS,
                ACCOMMODATION_DESCRIPTION
        );
        bookingDAO.insertAccommodation(accommodation);

        RoomFare roomFare = new RoomFare(ROOM_FARE_VALUE, ROOM_FARE_SEASON);
        bookingDAO.insertRoomFare(roomFare);

        AccommodationRoomFare accommodationRoomFare = new AccommodationRoomFare(
                accommodation.getId(),
                accommodation.getType(),
                roomFare.getValue(),
                roomFare.getSeason()
        );
        bookingDAO.insertAccommodationRoomFareRelation(accommodationRoomFare);

        List<AccommodationRoomFare> accommodationRoomFares = bookingDAO.getAccommodationRoomFares();
        assertTrue(accommodationRoomFares.size() > 0);

        AccommodationRoomFare firstAccommodationRoomFare = accommodationRoomFares.get(0);
        assertEquals(accommodation.getId(), firstAccommodationRoomFare.getAccommodationId());
        assertEquals(accommodation.getType(), firstAccommodationRoomFare.getAccommodationType());
        assertEquals(roomFare.getValue(), firstAccommodationRoomFare.getRoomFareValue());
        assertEquals(roomFare.getSeason(), firstAccommodationRoomFare.getRoomFareSeason());
    }
}
