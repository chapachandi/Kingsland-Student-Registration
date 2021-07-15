import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

import static javafx.application.Application.launch;

public class AppInitializer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/LoginForm.fxml"))));
       primaryStage.show();
    }
}
