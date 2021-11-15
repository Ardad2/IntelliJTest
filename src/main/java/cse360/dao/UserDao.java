package cse360.dao;
import cse360.util.MySQLConnectionUtil;
import cse360.model.Doctor;
import cse360.model.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public List<User> getAllUser() throws SQLException, ClassNotFoundException {
        List<User>  userList = new ArrayList<>();
        final String query = "Select * from user";
        Connection connection = MySQLConnectionUtil.getConnection();
        System.out.println("connection "+connection);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println(resultSet);
        //connection.close();
        while (resultSet.next()){
            System.out.println("Name " + resultSet.getString("first_name"));
            User user = new User(resultSet.getString("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("dob"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_no"),
                    resultSet.getString("password"));
                user.setType(resultSet.getString("user_type"));
            userList.add(user);
        }
        return userList;
    }

    public User getUserByEmailId(String email) throws SQLException, ClassNotFoundException {
        final String query = "Select * from USER WHERE email ='"+email+"'";
        Connection connection = MySQLConnectionUtil.getConnection();
        System.out.println("connection "+connection);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println(resultSet);
        //connection.close();
        User user =null;
       if(resultSet.next()){
            System.out.println("Name " + resultSet.getString("first_name"));
             user = new User(resultSet.getString("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("dob"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_no"),
                    resultSet.getString("password"));
             user.setType(resultSet.getString("user_type"));
        }
        return user;
    }

    public boolean checkForUserByType(String type, String email) throws SQLException, ClassNotFoundException {
        final String query = "Select * from USER WHERE email ='"+email+"' AND user_type ='"+type+"'";
        Connection connection = MySQLConnectionUtil.getConnection();
        System.out.println("connection "+connection);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println(resultSet);
        //connection.close();
        User user =null;
        if(resultSet.next()){
          return true;
        }
        return false;
    }


    public void createUser(User user) throws SQLException, ClassNotFoundException {

        Connection connection = MySQLConnectionUtil.getConnection();
        String insertQuery = "INSERT INTO USER (id,first_name,last_name,dob,email,phone_no,password, user_type) values(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareCall(insertQuery);
        preparedStatement.setString(1,user.getId());
        preparedStatement.setString(2,user.getFirstName());
        preparedStatement.setString(3,user.getLastName());
        preparedStatement.setString(4,  user.getDOB());
        preparedStatement.setString(5,user.getEmail());
        preparedStatement.setString(6,user.getPhoneNumber());
        preparedStatement.setString(7,user.getPassword());
        preparedStatement.setString(8, user.getType());

        long update = preparedStatement.executeLargeUpdate();
        if(update>0){
            System.out.println("Created success fully");
        }
    }

    public void updateUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnectionUtil.getConnection();
        String insertQuery = "UPDATE user set password = ?  WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareCall(insertQuery);
        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setString(2, user.getId());


        long update = preparedStatement.executeLargeUpdate();
        if(update>0){
            System.out.println("Updated successfully");
        }
    }

    public Doctor searchDoctor(String first_name, String last_name, String dob) throws SQLException, ClassNotFoundException {
        final String query = "SELECT * from USER WHERE first_name ="+first_name+"AND last_name="+last_name+"AND dob ="+dob+
                "AND user_type="+1;
        Connection connection = MySQLConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        Doctor foundDoctor = null;
        while(resultSet.next()){
            foundDoctor = new Doctor(resultSet.getString("id"),resultSet.getString("first_name"),
                    resultSet.getString("last_name"),resultSet.getString("dob"), resultSet.getString("email"),
                    resultSet.getString("phone_no"),resultSet.getString("password"));
            foundDoctor.setType(resultSet.getString("user_type"));

        }
        return foundDoctor;
    }

}
