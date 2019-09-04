package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskManager;

import java.util.List;

/**
 * Shows list of tasks that match the keyword of a 'find' command.
 */
public class FindCommand extends Command {
    private String keyword;

    FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public CommandResult execute(TaskManager taskManager) throws CommandExecutionException {
        try {
            List<Task> foundList = taskManager.findTasks(keyword);

            StringBuilder feedback = new StringBuilder();
            feedback.append("Here are the matching tasks in your list:\n");
            for (int i = 0; i < foundList.size(); ++i) {
                feedback.append(String.format("%d.%s\n", i + 1, foundList.get(i)));
            }

            return new CommandResult(feedback.toString());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'find' command");
        }
    }
}
