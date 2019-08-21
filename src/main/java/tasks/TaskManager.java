package tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
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

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task removeTask(int taskNumber) {
        return tasks.remove(taskNumber - 1);
    }

    public void markAsDone(int taskNumber) {
        tasks.get(taskNumber - 1).markAsDone();
    }
}
