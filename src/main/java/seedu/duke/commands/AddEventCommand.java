package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.tasks.Event;
import seedu.duke.tasks.TaskManager;

import java.io.IOException;

public class AddEventCommand extends AddTaskCommand {
    private String taskDescription;
    private String eventInfo;

    AddEventCommand(String taskDescription, String eventInfo) {
        this.taskDescription = taskDescription;
        this.eventInfo = eventInfo;
    }

    /**
     * Add an <code>Event</code> task to the list of tasks that are stored both in memory and database file.
     * Afterwards, this methods triggers a notification to the user that a new <code>Event</code> task has
     * been successfully added to the task list.
     *
     * @param taskManager A task manager that handles operations to the list of tasks.
     * @return A <code>CommandResult</code> that contains a feedback to the user in the form of <code>String</code>.
     * @throws CommandExecutionException An error that occurs during command execution
     *                                   (e.g. due to input/output failure when updating database file).
     */
    @Override
    public CommandResult execute(TaskManager taskManager) throws CommandExecutionException {
        Event event = new Event(taskDescription, eventInfo);
        try {
            taskManager.addTask(event);
            return getCommandResult(event, taskManager.getNumberOfTasks());
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'event' command");
        }
    }
}
