import tasks.Task;

import java.util.List;

class OutputWriter {
    private static String line = "    ____________________________________________________________";
    private static String tab = "     ";

    void printHeader() {
        System.out.println(line);
        System.out.println(tab + "Hello! I'm Duke\n" + "     What can I do for you?");
        System.out.println(line);
    }

    void printFooter() {
        System.out.println(line);
        System.out.println(tab + "Bye. Hope to see you again soon!");
        System.out.println(line);
    }

    void print(String s) {
        System.out.println(line);
        System.out.println(tab + s);
        System.out.println(line);
    }

    void notifyTaskDone(Task task) {
        System.out.println(line);
        System.out.println(tab + "Nice! I've marked this task as done:");
        System.out.println(tab + "  " + task);
        System.out.println(line);
    }

    void notifyAddTask(Task task, int numberOfTasks) {
        System.out.println(line);
        System.out.println(tab + "Got it. I've added this task:");
        System.out.println(tab + "  " + task);
        System.out.printf("%sNow you have %d tasks in the list.\n", tab, numberOfTasks);
        System.out.println(line);
    }

    void notifyRemoveTask(Task task, int numberOfTasks) {
        System.out.println(line);
        System.out.println(tab + "Noted. I've removed this task:");
        System.out.println(tab + "  " + task);
        System.out.printf("%sNow you have %d tasks in the list.\n", tab, numberOfTasks);
        System.out.println(line);
    }

    void printTasks(List<Task> tasks) {
        System.out.println(line);
        System.out.println(tab + "Here are the tasks in your list:");
        int number = 1;
        for (Task task : tasks) {
            System.out.printf("%s%d.%s\n", tab, number, task);
            number += 1;
        }
        System.out.println(line);
    }
}
