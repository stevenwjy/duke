package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandResult;
import seedu.duke.tasks.TaskManager;

public class Duke {
    private TaskManager taskManager;

    Duke(String filePath) throws Exception {
        this.taskManager = new TaskManager(filePath);
    }

    /**
     * Shows a header that is printed at the start of the chat bot.
     */
    public String getInitialMessage() {
        return "Hello! I'm Duke\nWhat can I do for you?";
    }

    /**
     * Returns response from duke chat bot. Initial data will be loaded from the
     * <code>filePath</code> that is specified upon initialization of <code>Duke</code> class.
     */
    public String getResponse(String inputLine) {
        try {
            Command command = Command.parseCommand(inputLine);
            CommandResult commandResult = command.execute(taskManager);
            return commandResult.feedbackToUser;
        } catch (Exception e) { // Show an error message to the user that is caught during the program execution.
            return "☹ OOPS!!! " + e.getMessage();
        }
    }
}
