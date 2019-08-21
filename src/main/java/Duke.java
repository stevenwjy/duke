import tasks.TaskManager;
import tasks.Event;
import tasks.Deadline;
import tasks.ToDo;

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
        try {
            switch (commandParts[0]) {
                case "list":
                    outputWriter.printTasks(taskManager.getTasks());
                    break;
                case "done":
                    int taskNumber = Integer.parseInt(commandParts[1]);
                    taskManager.markAsDone(taskNumber);
                    outputWriter.notifyTaskDone(taskManager.getTask(taskNumber));
                    break;
                case "todo":
                    ToDo todo = new ToDo(commandParts[1]);
                    taskManager.addTask(todo);
                    outputWriter.notifyAddTask(todo, taskManager.getNumberOfTasks());
                    break;
                case "event":
                    String[] eventParams = commandParts[1].split(" /at ", 2);
                    Event event = new Event(eventParams[0], eventParams[1]);
                    taskManager.addTask(event);
                    outputWriter.notifyAddTask(event, taskManager.getNumberOfTasks());
                    break;
                case "deadline":
                    String[] deadlineParams = commandParts[1].split(" /by ", 2);
                    Deadline deadline = new Deadline(deadlineParams[0], deadlineParams[1]);
                    taskManager.addTask(deadline);
                    outputWriter.notifyAddTask(deadline, taskManager.getNumberOfTasks());
                    break;
                default:
                    outputWriter.print("Invalid command!");
                    break;
            }
        } catch (Exception e) {
            outputWriter.print("Invalid command!");
        }
    }
}
