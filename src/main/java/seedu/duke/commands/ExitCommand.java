package seedu.duke.commands;

import seedu.duke.io.OutputWriter;
import seedu.duke.tasks.TaskManager;

public class ExitCommand extends Command {
    @Override
    public void execute(OutputWriter outputWriter, TaskManager taskManager) {
    }

    public static boolean isExit(Command c) {
        return (c instanceof ExitCommand);
    }
}
