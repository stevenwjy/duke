package seedu.duke.tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private TaskStorage taskStorage;

    public TaskManager(String filePath) throws Exception {
        taskStorage = new TaskStorage(filePath);
        tasks = taskStorage.loadTasks();
    }

    public int getNumberOfTasks() {
        return tasks.size();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int taskNumber) {
        return tasks.get(taskNumber - 1);
    }

    public void addTask(Task task) throws IOException {
        tasks.add(task);
        taskStorage.saveTasks(tasks);
    }

    /**
     * Removes a task from the list of tasks that is stored by Duke chat bot.
     *
     * @param taskNumber The index of the task in the list that will be removed.
     * @return The task that has been removed.
     * @throws IOException An error if Duke chat bot fails to save the changes to the data file.
     */
    public Task removeTask(int taskNumber) throws IOException {
        Task removedTask = tasks.remove(taskNumber - 1);
        taskStorage.saveTasks(tasks);
        return removedTask;
    }

    public void markAsDone(int taskNumber) throws IOException {
        tasks.get(taskNumber - 1).markAsDone();
        taskStorage.saveTasks(tasks);
    }

    /**
     * Find tasks that match the specified keyword.
     *
     * @param keyword A keyword that is searched in the task description.
     * @return List of tasks that match the specified keyword.
     */
    public List<Task> findTasks(String keyword) {
        List<Task> foundList = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                foundList.add(task);
            }
        }
        return foundList;
    }
}
