package cam.room;

import cam.utils.ConnectionUtils;
import cam.utils.Constant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class RoomDAO {
    public static int save(String roomid, String name, long capacity, String roomType, Timestamp availablefrom,
                           Timestamp availabletill, String availableFor, boolean available) {
        int status = 0;
        try {
            Connection con = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(Constant.ROOM_INSERT);
            preparedStatement.setString(1, roomid);
            preparedStatement.setString(2, name);
            preparedStatement.setLong(3, capacity);
            preparedStatement.setString(4, roomType);
            preparedStatement.setTimestamp(5, availablefrom);
            preparedStatement.setTimestamp(6, availabletill);
            preparedStatement.setString(7, availableFor);
            preparedStatement.setBoolean(8, available);
            status = preparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
