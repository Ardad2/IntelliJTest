package cse360;


import cse360.controllers.LoginController;
import cse360.dao.NurseDao;
import cse360.dao.UserDao;

import cse360.service.LoginService;
import cse360.service.NurseService;
import cse360.service.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class UserMain  extends Application {

    public static void main(String[] args) {
           launch(args);

        }

//        UserDao userDao = new UserDao();
//        NurseDao nurseDao = new NurseDao();
//        NurseService nurseService = new NurseService(userDao, nurseDao);
//        UserService userService = new UserService(userDao);
//        LoginService loginService = new LoginService(userDao);
//        try {
//            Doctor doctor = new Doctor(RandomNumberUtil.getRandomNumber(), "Devansh", "Bhavsar",
//                    "05/08/2002", "devansh8502@gmail.com", "4807291494", null);
//            Nurse nurse = new Nurse(RandomNumberUtil.getRandomNumber(), "Aashi", "Bhavsar", "12/17/2010",
//                    "aashi.er@gmail.com", "4801234565", null);
//
//
//            userService.addUser(doctor);
//            userService.addUser(nurse);
//            User doctorUser = userDao.getUserByEmailId(doctor.getEmail());
//            User nurseUser = userDao.getUserByEmailId(nurse.getEmail());
//
//            Patient patient = new Patient(RandomNumberUtil.getRandomNumber(), "Neha", "Bhavsar",
//                    "02/20/1979", "neha.er@gmail.com", "4804557740", null, "Aetna",
//                    "CVS", doctorUser.getId(), nurseUser.getId());
//
//            nurseService.addPatientService(patient);
//
//            int output = loginService.setAccount("devansh8502@gmail.com", "12345679", "12345679");
//            if (output == -1) {
//                System.out.println("account already exists");
//            }
//            if (output == -2) {
//                System.out.println("password is inappropriate or password don't match");
//            }
//            if (output == 1) {
//                System.out.println("account password set successfully");
//            }
//
//            User loggedInUser = loginService.login("devansh8502@gmail.com", "12345678", "Doctor");
//            System.out.println("...");
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        UserDao userDao = new UserDao();
        NurseDao nurseDao = new NurseDao();
        NurseService nurseService = new NurseService(userDao, nurseDao);
        UserService userService = new UserService(userDao);
        LoginService loginService = new LoginService(userDao);

        primaryStage.setTitle("Login");

        URL url = getClass().getResource("/login.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        LoginController loginController = loader.getController();
        loginController.initService(primaryStage, loginService);
        Scene loginScene = new Scene(root);
        primaryStage.setScene(loginScene);
        primaryStage.show();

    }
}

