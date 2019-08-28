package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.io.OutputWriter;
import seedu.duke.tasks.Deadline;
import seedu.duke.tasks.TaskManager;

import java.io.IOException;

public class AddDeadlineCommand extends Command {
    private String taskDescription;
    private String deadlineInfo;

    public AddDeadlineCommand(String taskDescription, String deadlineInfo) {
        this.taskDescription = taskDescription;
        this.deadlineInfo = deadlineInfo;
    }

    @Override
    public void execute(OutputWriter outputWriter, TaskManager taskManager) throws CommandExecutionException {
        Deadline deadline = new Deadline(taskDescription, deadlineInfo);

        try {
            taskManager.addTask(deadline);
            outputWriter.notifyAddTask(deadline, taskManager.getNumberOfTasks());
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'deadline' command");
        }
    }
}
