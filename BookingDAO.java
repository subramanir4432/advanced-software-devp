package cam.booking;

import cam.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static cam.utils.Constant.*;

public class BookingDAO {

    public static List<String> getAvilableRooms() {
        List<String> roomIds = new ArrayList();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ROOM_SELECT_ACTIVE);
            preparedStatement.setBoolean(1, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roomIds.add(resultSet.getString("room_id"));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return roomIds;
    }

    public static int save(String roomid, String bookedby, String guestid, String guestaddress, String guestcontact, String bookedfor,
                           Timestamp bookedfrom, Timestamp bookedto, String reason) {
        int status = 0;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BOOKING_INSERT);
            preparedStatement.setString(1, roomid);
            preparedStatement.setString(2, bookedby);
            preparedStatement.setString(3, guestid);
            preparedStatement.setString(4, guestaddress);
            preparedStatement.setString(5, guestcontact);
            preparedStatement.setString(6, bookedfor);
            preparedStatement.setTimestamp(7, bookedfrom);
            preparedStatement.setTimestamp(8, bookedto);
            preparedStatement.setString(9, reason);
            status = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int delete(String bookingId) {
        int status = 0;
        try {
            Connection connection = ConnectionUtils.getConnection();
            if (status > 0) {
                PreparedStatement preparedStatement = connection.prepareStatement(BOOKING_DELETE);
                preparedStatement.setLong(1, Long.parseLong(bookingId));
                status = preparedStatement.executeUpdate();
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
