import java.util.List;

class OutputWriter {
    private static String line = "    ____________________________________________________________";
    private static String tab = "     ";

    private static String header = "Hello! I'm Duke\n" + "     What can I do for you?";
    private static String footer = "Bye. Hope to see you again soon!";

    private static String listResponseHeader = "Here are the tasks in your list:";
    private static String taskDoneResponseHeader = "Nice! I've marked this task as done:";

    void printHeader() {
        System.out.println(line);
        System.out.println(tab + header);
        System.out.println(line);
    }

    void printFooter() {
        System.out.println(line);
        System.out.println(tab + footer);
        System.out.println(line);
    }

    void print(String s) {
        System.out.println(line);
        System.out.println(tab + s);
        System.out.println(line);
    }

    void printTaskDone(Task task) {
        System.out.println(line);
        System.out.println(tab + taskDoneResponseHeader);
        System.out.println(tab + "  " + task.toString());
        System.out.println(line);
    }

    void printTasks(List<Task> tasks) {
        System.out.println(line);
        System.out.println(tab + listResponseHeader);
        int number = 1;
        for (Task task : tasks) {
            System.out.printf("%s%d.%s\n", tab, number, task);
            number += 1;
        }
        System.out.println(line);
    }
}
