package seedu.duke.commands;

import seedu.duke.tasks.Task;

abstract class AddTaskCommand extends Command {
    static CommandResult getCommandResult(Task task, int numberOfTasks) {
        return new CommandResult("Got it. I've added this task:\n" + "  " + task + "\n" +
                String.format("Now you have %d tasks in the list.\n", numberOfTasks));
    }
}
