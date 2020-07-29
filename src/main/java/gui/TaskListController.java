package gui;

import data.Task;
import db.LocalDbConnect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaskListController extends Application {
    Parent root;
    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/fxml/taskList.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Task List");
        stage.setScene(scene);
        stage.show();

        ListView<String> listView = (ListView<String>)scene.lookup("#taskListView");
        ArrayList<Task> tasks = LocalDbConnect.getTasksList();

        //Populating the list
        for(Task t : tasks){
            listView.getItems().add(t.getDataString());
        }

    }
}
