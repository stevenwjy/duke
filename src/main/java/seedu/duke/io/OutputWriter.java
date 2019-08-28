package seedu.duke.io;

import seedu.duke.tasks.Task;

import java.io.PrintStream;
import java.util.List;

public class OutputWriter {
    private static String line = "    ____________________________________________________________";
    private static String tab = "     ";
    private PrintStream out = System.out;

    /**
     * Shows a header that is printed at the start of the chat bot.
     */
    public void showHeader() {
        out.println(line);
        out.println(tab + "Hello! I'm Duke\n" + "     What can I do for you?");
        out.println(line);
    }

    /**
     * Shows a footer that is printed when the chat bot is about to terminate.
     */
    public void showFooter() {
        out.println(line);
        out.println(tab + "Bye. Hope to see you again soon!");
        out.println(line);
    }

    /**
     * Shows a notification to the user that a task has been successfully marked as done.
     *
     * @param task The task that has been marked as done.
     */
    public void notifyTaskDone(Task task) {
        out.println(line);
        out.println(tab + "Nice! I've marked this task as done:");
        out.println(tab + "  " + task);
        out.println(line);
    }

    /**
     * Shows a notification to the user that a new task has been successfully added to the task list.
     *
     * @param task          The task that has been successfully added.
     * @param numberOfTasks The new number of tasks in the task list.
     */
    public void notifyAddTask(Task task, int numberOfTasks) {
        out.println(line);
        out.println(tab + "Got it. I've added this task:");
        out.println(tab + "  " + task);
        out.printf("%sNow you have %d tasks in the list.\n", tab, numberOfTasks);
        out.println(line);
    }

    /**
     * Shows a notification to the user that a task has been successfully removed from the task list.
     *
     * @param task          The task that has been successfully removed.
     * @param numberOfTasks The new number of tasks in the task list.
     */
    public void notifyRemoveTask(Task task, int numberOfTasks) {
        out.println(line);
        out.println(tab + "Noted. I've removed this task:");
        out.println(tab + "  " + task);
        out.printf("%sNow you have %d tasks in the list.\n", tab, numberOfTasks);
        out.println(line);
    }

    /**
     * Shows the list of tasks to the user.
     *
     * @param tasks List of tasks that is stored by the chat bot.
     */
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

    /**
     * Show list of tasks that match the keyword of a 'find' command.
     *
     * @param tasks List of tasks that match the keyword of a 'find' command.
     */
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

    /**
     * Show an error message to the user that is caught during the program execution.
     *
     * @param errorMessage A description of the error that is caught by the program.
     */
    public void showError(String errorMessage) {
        out.println(line);
        out.println(tab + "☹ OOPS!!! " + errorMessage);
        out.println(line);
    }
}
