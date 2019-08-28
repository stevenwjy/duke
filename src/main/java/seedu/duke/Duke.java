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
}
