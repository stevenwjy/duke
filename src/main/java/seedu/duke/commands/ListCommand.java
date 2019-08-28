package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.io.OutputWriter;
import seedu.duke.tasks.TaskManager;

public class ListCommand extends Command {
    @Override
    public void execute(OutputWriter outputWriter, TaskManager taskManager) throws CommandExecutionException {
        try {
            outputWriter.showTasks(taskManager.getTasks());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'list' command");
        }
    }
}
