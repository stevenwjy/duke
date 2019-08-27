package duke;

import duke.io.InputReader;
import duke.io.InvalidInputException;
import duke.io.OutputWriter;
import duke.tasks.*;

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
                    if (commandParts.length < 2) {
                        throw new InvalidInputException(InvalidInputException.Code.EMPTY_DONE_DESCRIPTION);
                    }

                    try {
                        int taskNumber = Integer.parseInt(commandParts[1]);
                        taskManager.markAsDone(taskNumber);
                        outputWriter.notifyTaskDone(taskManager.getTask(taskNumber));
                    } catch (Exception e) {
                        throw new InvalidInputException(InvalidInputException.Code.INVALID_TASK_NUMBER);
                    }
                    break;
                case "delete":
                    if (commandParts.length < 2) {
                        throw new InvalidInputException(InvalidInputException.Code.EMPTY_DELETE_DESCRIPTION);
                    }

                    try {
                        int taskNumber = Integer.parseInt(commandParts[1]);
                        Task removedTask = taskManager.removeTask(taskNumber);
                        outputWriter.notifyRemoveTask(removedTask, taskManager.getNumberOfTasks());
                    } catch (Exception e) {
                        throw new InvalidInputException(InvalidInputException.Code.INVALID_TASK_NUMBER);
                    }
                    break;
                case "todo":
                    if (commandParts.length < 2) {
                        throw new InvalidInputException(InvalidInputException.Code.EMPTY_TODO_DESCRIPTION);
                    }

                    ToDo todo = new ToDo(commandParts[1]);
                    taskManager.addTask(todo);
                    outputWriter.notifyAddTask(todo, taskManager.getNumberOfTasks());
                    break;
                case "event":
                    if (commandParts.length < 2) {
                        throw new InvalidInputException(InvalidInputException.Code.EMPTY_EVENT_DESCRIPTION);
                    }

                    String[] eventParams = commandParts[1].split(" /at ", 2);
                    if (eventParams.length < 2) {
                        throw new InvalidInputException(InvalidInputException.Code.MISSING_EVENT_PARAMETER);
                    }

                    Event event = new Event(eventParams[0], eventParams[1]);
                    taskManager.addTask(event);
                    outputWriter.notifyAddTask(event, taskManager.getNumberOfTasks());
                    break;
                case "deadline":
                    if (commandParts.length < 2) {
                        throw new InvalidInputException(InvalidInputException.Code.EMPTY_DEADLINE_DESCRIPTION);
                    }

                    String[] deadlineParams = commandParts[1].split(" /by ", 2);
                    if (deadlineParams.length < 2) {
                        throw new InvalidInputException(InvalidInputException.Code.MISSING_DEADLINE_PARAMETER);
                    }

                    Deadline deadline = new Deadline(deadlineParams[0], deadlineParams[1]);
                    taskManager.addTask(deadline);
                    outputWriter.notifyAddTask(deadline, taskManager.getNumberOfTasks());
                    break;
                default:
                    throw new InvalidInputException(InvalidInputException.Code.UNKNOWN_COMMAND);
            }
        } catch (InvalidInputException e) {
            outputWriter.print(e.errorDescription());
        }
    }
}
