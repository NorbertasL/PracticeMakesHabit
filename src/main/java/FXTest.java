import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXTest extends Application {
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("FX Test");
        stage.setScene(new Scene(new Button("Test BTN")));
        stage.show();
    }
}
