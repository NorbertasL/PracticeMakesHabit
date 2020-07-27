import db.LocalDbConnect;
import gui.LogInController;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        startUp();

    }

    @Override
    public void start(Stage stage) throws Exception {
        new LogInController().start(stage);
    }
    private static void startUp(){
        //Creating DB and Tables
        LocalDbConnect.createdLocalDatabase();
        LocalDbConnect.createNewTable(LocalDbConnect.Tables.DAILY_TASKS);
        LocalDbConnect.createNewTable(LocalDbConnect.Tables.DAILY_TASK_TRACKER);

    }
}
