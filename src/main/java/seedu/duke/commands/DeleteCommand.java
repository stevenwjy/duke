package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.commands.exceptions.InvalidCommandException;
import seedu.duke.io.OutputWriter;
import seedu.duke.tasks.TaskManager;

import java.io.IOException;

public class DeleteCommand extends Command {
    private int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(OutputWriter outputWriter, TaskManager taskManager)
            throws InvalidCommandException, CommandExecutionException {
        try {
            taskManager.removeTask(taskNumber);
            outputWriter.notifyTaskDone(taskManager.getTask(taskNumber));
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidCommandException("Task number does not exist");
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'delete' command");
        }
    }
}
