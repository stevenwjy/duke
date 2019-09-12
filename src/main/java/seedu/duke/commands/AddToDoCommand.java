package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.tasks.TaskManager;
import seedu.duke.tasks.ToDo;

import java.io.IOException;

/**
 * Shows a notification to the user that a new <code>ToDo</code> task has been successfully added to the task list.
 */
public class AddToDoCommand extends AddTaskCommand {
    private String taskDescription;

    AddToDoCommand(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public CommandResult execute(TaskManager taskManager) throws CommandExecutionException {
        ToDo todo = new ToDo(taskDescription);
        try {
            int oldNumberOfTasks = taskManager.getNumberOfTasks();
            taskManager.addTask(todo);
            assert (oldNumberOfTasks + 1) == taskManager.getNumberOfTasks();

            return getCommandResult(todo, taskManager.getNumberOfTasks());
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'todo' command");
        }
    }
}
