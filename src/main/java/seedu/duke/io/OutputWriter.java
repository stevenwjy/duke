package seedu.duke.io;

import seedu.duke.tasks.Task;

import java.io.PrintStream;
import java.util.List;

public class OutputWriter {
    private static String line = "    ____________________________________________________________";
    private static String tab = "     ";
    private PrintStream out = System.out;

    public void showHeader() {
        out.println(line);
        out.println(tab + "Hello! I'm Duke\n" + "     What can I do for you?");
        out.println(line);
    }

    public void showFooter() {
        out.println(line);
        out.println(tab + "Bye. Hope to see you again soon!");
        out.println(line);
    }

    public void notifyTaskDone(Task task) {
        out.println(line);
        out.println(tab + "Nice! I've marked this task as done:");
        out.println(tab + "  " + task);
        out.println(line);
    }

    public void notifyAddTask(Task task, int numberOfTasks) {
        out.println(line);
        out.println(tab + "Got it. I've added this task:");
        out.println(tab + "  " + task);
        out.printf("%sNow you have %d tasks in the list.\n", tab, numberOfTasks);
        out.println(line);
    }

    public void notifyRemoveTask(Task task, int numberOfTasks) {
        out.println(line);
        out.println(tab + "Noted. I've removed this task:");
        out.println(tab + "  " + task);
        out.printf("%sNow you have %d tasks in the list.\n", tab, numberOfTasks);
        out.println(line);
    }

    public void showTasks(List<Task> tasks) {
        out.println(line);
        out.println(tab + "Here are the tasks in your list:");
        int number = 1;
        for (Task task : tasks) {
            out.printf("%s%d.%s\n", tab, number, task);
            number += 1;
        }
        out.println(line);
    }

    public void showTasksFound(List<Task> tasks) {
        out.println(line);
        out.println(tab + "Here are the matching tasks in your list:");
        int number = 1;
        for (Task task : tasks) {
            out.printf("%s%d.%s\n", tab, number, task);
            number += 1;
        }
        out.println(line);
    }

    public void showError(String errorMessage) {
        out.println(line);
        out.println(tab + "☹ OOPS!!! " + errorMessage);
        out.println(line);
    }
}
