import java.util.List;

class OutputWriter {
    private static String line = "    ____________________________________________________________";
    private static String header = "Hello! I'm Duke\n" + "     What can I do for you?";
    private static String footer = "Bye. Hope to see you again soon!";
    private static String tab = "     ";

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

    void printTasks(List<Task> tasks) {
        System.out.println(line);
        int number = 1;
        for (Task task : tasks) {
            System.out.printf("%s%d. %s\n", tab, number, task);
            number += 1;
        }
        System.out.println(line);
    }
}
