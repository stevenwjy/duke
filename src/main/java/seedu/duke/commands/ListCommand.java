package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskManager;

import java.util.List;

/**
 * Shows the list of tasks to the user.
 */
public class ListCommand extends Command {
    @Override
    public CommandResult execute(TaskManager taskManager) throws CommandExecutionException {
        try {
            List<Task> tasks = taskManager.getTasks();

            StringBuilder feedback = new StringBuilder();
            feedback.append("Here are the tasks in your list:\n");
            for (int i = 0; i < tasks.size(); ++i) {
                feedback.append(String.format("%d.%s\n", i, tasks.get(i)));
            }

            return new CommandResult(feedback.toString());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'list' command");
        }
    }
}
