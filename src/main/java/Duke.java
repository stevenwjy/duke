import java.util.List;
import java.util.ArrayList;

public class Duke {
    private static InputReader inputReader;
    private static OutputWriter outputWriter;
    private static List<Task> tasks;

    public static void main(String[] args) {
        inputReader = new InputReader();
        outputWriter = new OutputWriter();
        tasks = new ArrayList<Task>();

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
        switch (command) {
            case "list":
                outputWriter.printTasks(tasks);
                break;
            default:
                tasks.add(new Task(command));
                outputWriter.print("added: " + command);
                break;
        }
    }
}
