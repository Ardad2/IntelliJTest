package cse360.controllers;

import cse360.service.LoginService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DoctorController {

    private LoginService loginService;
    private Stage primaryStage;

    public void initService(Stage primaryStage, LoginService loginService){
        this.loginService = loginService;
        this.primaryStage = primaryStage;
    }

    public void logOut(MouseEvent mouseEvent) throws IOException {
        URL url = getClass().getResource("/login.fxml");
        System.out.println(url.toString());
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        LoginController loginController = loader.getController();
        loginController.initService(primaryStage, loginService);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
