import java.util.List;
import java.util.ArrayList;

public class Duke {
    private static InputReader inputReader;
    private static OutputWriter outputWriter;
    private static TaskManager taskManager;

    public static void main(String[] args) {
        inputReader = new InputReader();
        outputWriter = new OutputWriter();
        taskManager = new TaskManager();

        run();
    }

    private static void run() {
        outputWriter.printHeader();
        while (inputReader.hasNextCommand()) {
            String command = inputReader.nextCommand();
            handleCommand(command);
        }
        outputWriter.printFooter();
    }

    private static void handleCommand(String command) {
        String[] commandParts = command.split(" ", 2);
        switch (commandParts[0]) {
            case "list":
                outputWriter.printTasks(taskManager.getTasks());
                break;
            case "done":
                int taskNumber = Integer.parseInt(commandParts[1]);
                taskManager.markAsDone(taskNumber);
                outputWriter.printTaskDone(taskManager.getTask(taskNumber));
                break;
            default:
                taskManager.addTask(new Task(command));
                outputWriter.print("added: " + command);
                break;
        }
    }
}
