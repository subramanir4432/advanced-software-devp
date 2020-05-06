package cam.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import static cam.utils.Constant.*;

public class ConnectionUtils {
    public static Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName(DRIVER_NAME);
            connection= DriverManager.getConnection(DB_URL,DB_USER_NAME,DB_PASS);
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
