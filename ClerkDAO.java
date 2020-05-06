package cam.user;

import cam.utils.Constant;
import cam.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClerkDAO {

    public static int save(String name, String password, String email, String address, String city, String contact){
        int status=0;
        try{
            Connection connection= ConnectionUtils.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(Constant.USER_INSERT);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,city);
            preparedStatement.setString(6,contact);
            status=preparedStatement.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }
    public static int delete(int id){
        int status=0;
        try{
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(Constant.USER_DELETE);
            preparedStatement.setInt(1,id);
            status=preparedStatement.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }

    public static boolean validate(String name,String password){
        boolean status=false;
        try{
            Connection connection=ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Constant.USER_LOGIN_SELECT);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            ResultSet rs=preparedStatement.executeQuery();
            status=rs.next();
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }

}
