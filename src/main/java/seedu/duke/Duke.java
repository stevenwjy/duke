package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.io.InputReader;
import seedu.duke.io.OutputWriter;
import seedu.duke.tasks.TaskManager;

public class Duke {
    private InputReader inputReader = new InputReader();
    private OutputWriter outputWriter = new OutputWriter();
    private TaskManager taskManager;

    public Duke(String filePath) throws Exception {
        this.taskManager = new TaskManager(filePath);
    }

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
            outputWriter.showError("Program is terminated due to unexpected behavior ... " +
                    "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            new Duke("data/tasks.txt").run();
        } catch (Exception e) {
            System.out.println("Failed to run the main program, error: " + e.getMessage());
        }
    }
}
