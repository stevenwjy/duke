package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.commands.exceptions.InvalidCommandException;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskManager;

import java.io.IOException;

/**
 * Shows a notification to the user that a task has been successfully removed from the task list.
 */
public class DeleteCommand extends Command {
    private int taskNumber;

    DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public CommandResult execute(TaskManager taskManager) throws InvalidCommandException, CommandExecutionException {
        try {
            Task removedTask = taskManager.removeTask(taskNumber);
            return new CommandResult("Noted. I've removed this task:\n" + "  " + removedTask + "\n"
                    + String.format("Now you have %d tasks in the list.\n", taskManager.getNumberOfTasks()));
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidCommandException("Task number does not exist");
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'delete' command");
        }
    }
}
