package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//https://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm

public class LogInController extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/logIn.fxml"));
        Scene scene = new Scene(root, 300,200);
        stage.setTitle("Log In...");
        stage.setScene(scene);
        stage.show();

    }

    public void handleSubmitButtonAction(ActionEvent actionEvent) {
    }
}
