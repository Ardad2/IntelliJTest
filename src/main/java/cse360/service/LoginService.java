package cse360.service;

import cse360.dao.UserDao;
import cse360.model.User;

import java.sql.SQLException;

public class LoginService {
    private UserDao userDao;

    public LoginService(UserDao userDao){
        this.userDao = userDao;
    }

    /**
     * This method will do ...
     * @param email
     * @param password
     * @return User Object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public User login(String email, String password, String type) throws SQLException, ClassNotFoundException {
        String typeInt;
        if(type.equals("Doctor")){
            typeInt = "1";
        }
        else if(type.equals("Nurse")){
            typeInt = "2";
        }
        else if (type.equals("Patient")){
            typeInt ="3";
        }
        else{
            typeInt = "-1";
        }

        if(userDao.checkForUserByType(typeInt, email)) {

                User foundUser = userDao.getUserByEmailId(email);

                if (null == foundUser) {
                    System.out.println("Account does not exists");
                    return null;

                }
                if (null == foundUser.getPassword()) {
                    System.out.println("Account password not set.");
                    return null;

                }
                if (foundUser.getEmail().equals(email) && foundUser.getPassword().equals(password)) {
                    System.out.println("login sucessfull");
                    return foundUser;
                }
            }
        else{
            System.out.println("user credentials don't match");
            return null;
        }
        return null;


    }

    /**
     *
     * @param password
     */
    public int setAccountPassword(String email, String password, String rePassword) throws SQLException, ClassNotFoundException {

        User foundUser = userDao.getUserByEmailId(email);
        if(foundUser == null){
            return -1; // user does not exist
        }
        else{
            if(foundUser.getPassword() != null && !foundUser.getPassword().equals("")){
                System.out.println(foundUser.getPassword());
                return -2; // password is already set for this account
            }
            else if(checkForAppPassword(password) && password.equals(rePassword)){
                foundUser.setPassword(password);
                userDao.updateUser(foundUser);
                return 1;
            }
            else{
                return -3; // password is inappropriate or passwords don't match
            }
        }
    }

    public boolean checkForAppPassword(String password){
        if(password.length()>7 && !password.equals("password")){
            return true;
        }
        return false;
    }
}
