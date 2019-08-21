package tasks;

import java.util.List;
import java.util.ArrayList;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public int getNumberOfTasks() { return tasks.size(); }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int taskNumber) {
        return tasks.get(taskNumber - 1);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markAsDone(int taskNumber) {
        tasks.get(taskNumber - 1).markAsDone();
    }
}
