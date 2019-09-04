package seedu.duke;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.io.DialogBox;
import seedu.duke.io.InputReader;
import seedu.duke.io.OutputWriter;
import seedu.duke.tasks.TaskManager;

public class Duke extends Application {
    private InputReader inputReader = new InputReader();
    private OutputWriter outputWriter = new OutputWriter();
    private TaskManager taskManager;

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    Image user = new Image(this.getClass().getResourceAsStream("/images/user.jpg"));
    Image duke = new Image(this.getClass().getResourceAsStream("/images/duke.jpg"));

    public Duke(String filePath) throws Exception {
        this.taskManager = new TaskManager(filePath);
    }

    public Duke() throws Exception {
        String filePath = "data/tasks.txt";
        this.taskManager = new TaskManager(filePath);
    }

    /**
     * Run duke chat bot. This function will trigger reading from <code>System.in</code>
     * and printing output to <code>System.out</code>. Initial data will be loaded from the
     * <code>filePath</code> that is specified upon initialization of <code>Duke</code> class.
     */
    public void run() {
        outputWriter.showHeader();
        try {
            while (true) {
                String inputLine = inputReader.nextLine();
                try {
                    Command command = Command.parseCommand(inputLine);
                    command.execute(outputWriter, taskManager);
                    if (ExitCommand.isExit(command)) {
                        outputWriter.showFooter();
                        break;
                    }
                } catch (Exception e) {
                    outputWriter.showError(e.getMessage());
                }
            }
        } catch (Exception e) {
            outputWriter.showError("Program is terminated due to unexpected behavior ... "
                    + "Error: " + e.getMessage());
        }
    }

    /**
     * Default main function for <code>Duke</code> class. Calling this function will run a chat bot with
     * default task data at 'data/task.txt'. If there is no such file, the program will create an empty
     * file.
     *
     * @param args Arguments that are provided upon running the program. Those arguments will not give
     *             any effect towards the program execution.
     */
    public static void main(String[] args) {
        try {
            new Duke("data/tasks.txt").run();
        } catch (Exception e) {
            System.out.println("Failed to run the main program, error: " + e.getMessage());
        }
    }

    @Override
    public void start(Stage stage) {
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
        });

        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);
        formatWindow(stage, mainLayout);

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     * @param text String containing text to add
     * @return a label with the specified text that has word wrap enabled.
     */
    private Label getDialogLabel(String text) {
        // You will need to import `javafx.scene.control.Label`.
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }

    private void formatWindow(Stage stage, AnchorPane mainLayout) {
        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput, 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);
    }

    /**
     * Iteration 2:
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    private void handleUserInput() {
        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText()));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(user)),
                DialogBox.getDukeDialog(dukeText, new ImageView(duke))
        );
        userInput.clear();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private String getResponse(String input) {
        return "Duke heard: " + input;
    }
}
