package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.commands.exceptions.InvalidCommandException;
import seedu.duke.tasks.TaskManager;

import java.io.IOException;

/**
 * Shows a notification to the user that a task has been successfully marked as done.
 */
public class DoneCommand extends Command {
    private int taskNumber;

    DoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public CommandResult execute(TaskManager taskManager) throws InvalidCommandException, CommandExecutionException {
        try {
            int oldNumberOfTasks = taskManager.getNumberOfTasks();
            taskManager.markAsDone(taskNumber);
            assert oldNumberOfTasks == taskManager.getNumberOfTasks();

            return new CommandResult("Nice! I've marked this task as done:\n"
                    + "  " + taskManager.getTask(taskNumber) + "\n");
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidCommandException("Task number does not exist");
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'done' command");
        }
    }
}
