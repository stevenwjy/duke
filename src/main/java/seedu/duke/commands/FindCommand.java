package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.io.OutputWriter;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskManager;

import java.util.List;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(OutputWriter outputWriter, TaskManager taskManager) throws CommandExecutionException {
        try {
            List<Task> foundList = taskManager.findTasks(keyword);
            outputWriter.showTasksFound(foundList);
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'find' command");
        }
    }
}
