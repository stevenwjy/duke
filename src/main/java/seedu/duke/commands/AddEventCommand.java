package seedu.duke.commands;

import seedu.duke.commands.exceptions.CommandExecutionException;
import seedu.duke.io.OutputWriter;
import seedu.duke.tasks.Event;
import seedu.duke.tasks.TaskManager;

import java.io.IOException;

public class AddEventCommand extends Command {
    private String taskDescription;
    private String eventInfo;

    public AddEventCommand(String taskDescription, String eventInfo) {
        this.taskDescription = taskDescription;
        this.eventInfo = eventInfo;
    }

    @Override
    public void execute(OutputWriter outputWriter, TaskManager taskManager) throws CommandExecutionException {
        Event event = new Event(taskDescription, eventInfo);

        try {
            taskManager.addTask(event);
            outputWriter.notifyAddTask(event, taskManager.getNumberOfTasks());
        } catch (IOException e) {
            throw new CommandExecutionException(e.getMessage());
        } catch (Exception e) {
            throw new CommandExecutionException("Unknown error occurred while executing 'event' command");
        }
    }
}
