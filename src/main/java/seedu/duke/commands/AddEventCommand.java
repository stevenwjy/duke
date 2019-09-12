package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.tasks.Event;
import seedu.duke.tasks.TaskManager;

import java.io.IOException;

/**
 * Shows a notification to the user that a new <code>Event</code> task has been successfully added to the task list.
 */
public class AddEventCommand extends AddTaskCommand {
    private String taskDescription;
    private String eventInfo;

    AddEventCommand(String taskDescription, String eventInfo) {
        this.taskDescription = taskDescription;
        this.eventInfo = eventInfo;
    }

    @Override
    public CommandResult execute(TaskManager taskManager) throws CommandExecutionException {
        Event event = new Event(taskDescription, eventInfo);
        try {
            int oldNumberOfTasks = taskManager.getNumberOfTasks();
            taskManager.addTask(event);
            assert (oldNumberOfTasks + 1) == taskManager.getNumberOfTasks();

            return getCommandResult(event, taskManager.getNumberOfTasks());
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'event' command");
        }
    }
}
