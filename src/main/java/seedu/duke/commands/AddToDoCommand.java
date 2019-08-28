package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.io.OutputWriter;
import seedu.duke.tasks.TaskManager;
import seedu.duke.tasks.ToDo;

import java.io.IOException;

public class AddToDoCommand extends Command {
    private String taskDescription;

    public AddToDoCommand(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(OutputWriter outputWriter, TaskManager taskManager) throws CommandExecutionException {
        ToDo todo = new ToDo(taskDescription);
        try {
            taskManager.addTask(todo);
            outputWriter.notifyAddTask(todo, taskManager.getNumberOfTasks());
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'todo' command");
        }
    }
}
