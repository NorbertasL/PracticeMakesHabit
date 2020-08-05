import data.Task;
import db.LocalDbConnect;
import gui.LogInController;
import gui.TaskListController;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        startUp();
        LocalDbConnect.delete(LocalDbConnect.Tables.DAILY_TASKS, 4);
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        new TaskListController().start(stage);
    }
    private static void startUp(){
        //Creating DB and Tables
        LocalDbConnect.createdLocalDatabase();
        LocalDbConnect.createNewTable(LocalDbConnect.Tables.DAILY_TASKS);
        LocalDbConnect.createNewTable(LocalDbConnect.Tables.DAILY_TASK_TRACKER);

    }
}
