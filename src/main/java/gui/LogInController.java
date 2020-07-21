package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LogInController extends Application {
    Parent root;
    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/fxml/logIn.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Log In...");
        stage.setScene(scene);
        stage.show();

    }

    public void newUserAction(ActionEvent actionEvent) {
        System.out.println("New User");
    }

    public void passwordResetAction(ActionEvent actionEvent) {
        System.out.println("Password Reset");
    }

    public void logInBtnAction(ActionEvent actionEvent) {
        System.out.println("Log in !!!");
    }
}
