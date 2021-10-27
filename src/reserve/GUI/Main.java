package reserve.GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Aminous
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ajout.fxml"))));
        // primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("AfficheReservationAdmin.fxml"))));

        primaryStage.setTitle("Reserve");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}