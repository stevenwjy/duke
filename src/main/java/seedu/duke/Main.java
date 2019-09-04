package seedu.duke;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import seedu.duke.ui.MainWindow;

import java.io.IOException;
import java.util.Arrays;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {
    private Duke duke;

    /**
     * Constructor for Main application of Duke chat bot. If it fails to initialize Duke class, then it will
     * print the stack trace that causes the error to standard output.
     */
    public Main() {
        try {
            duke = new Duke("data/tasks.txt");
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Starts the duke chat bot.
     *
     * @param stage A stage to display the GUI for Duke app.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}