package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.tasks.Deadline;
import seedu.duke.tasks.TaskManager;

import java.io.IOException;

/**
 * Shows a notification to the user that a new <code>Deadline</code> task has been successfully added to the task list.
 */
public class AddDeadlineCommand extends AddTaskCommand {
    private String taskDescription;
    private String deadlineInfo;

    AddDeadlineCommand(String taskDescription, String deadlineInfo) {
        this.taskDescription = taskDescription;
        this.deadlineInfo = deadlineInfo;
    }

    @Override
    public CommandResult execute(TaskManager taskManager) throws CommandExecutionException {
        Deadline deadline = new Deadline(taskDescription, deadlineInfo);
        try {
            int oldNumberOfTasks = taskManager.getNumberOfTasks();
            taskManager.addTask(deadline);
            assert (oldNumberOfTasks + 1) == taskManager.getNumberOfTasks();

            return getCommandResult(deadline, taskManager.getNumberOfTasks());
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'deadline' command");
        }
    }
}
