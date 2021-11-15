package cse360.service;

import cse360.dao.UserDao;
import cse360.model.User;

import java.sql.*;
import java.util.List;

public class UserService {
    List<User> userList;

    private UserDao userDao;

    public UserService(UserDao userDao) {

        this.userDao = userDao;
    }

    public void addUser(User user) throws SQLException, ClassNotFoundException {
        User foundUser = userDao.getUserByEmailId(user.getEmail());
        if(foundUser != null){
            System.out.println("Trying to add duplicate user");
        }
        else {
            userDao.createUser(user);
        }
    }

    public boolean login(User user) throws SQLException, ClassNotFoundException {
        User dbUser = userDao.getUserByEmailId(user.getEmail());
        if(dbUser.getPassword().equals(user.getPassword())) {
            return true;
        }
        return false;
    }




}
