package seedu.duke.tasks;

import java.io.IOException;
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

    public Task removeTask(int taskNumber) throws IOException {
        Task removedTask = tasks.remove(taskNumber - 1);
        taskStorage.saveTasks(tasks);
        return removedTask;
    }

    public void markAsDone(int taskNumber) throws IOException {
        tasks.get(taskNumber - 1).markAsDone();
        taskStorage.saveTasks(tasks);
    }
}
