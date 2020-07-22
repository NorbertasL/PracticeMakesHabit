import db.LocalDbConnect;
import gui.LogInController;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {

        //launch(args);
        LocalDbConnect.createNewTable(LocalDbConnect.Tables.DAILY);
        LocalDbConnect.insert(LocalDbConnect.Tables.DAILY,"Read Book 5 min", 30000, "FFFFFF");
        LocalDbConnect.insert(LocalDbConnect.Tables.DAILY,"Work out 5 min", 344300, "FAA8FF");
        LocalDbConnect.insert(LocalDbConnect.Tables.DAILY,"Go to bed early", 30000, "00FF00");
    }

    @Override
    public void start(Stage stage) throws Exception {
        new LogInController().start(stage);
    }
}
