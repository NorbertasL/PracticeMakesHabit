package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddTaskController extends Application {
    Parent root;
    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/fxml/addTask.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Add Task");
        stage.setScene(scene);
        stage.show();

    }
}
