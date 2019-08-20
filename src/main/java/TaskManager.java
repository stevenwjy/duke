import java.util.List;
import java.util.ArrayList;

class TaskManager {
    private List<Task> tasks;

    TaskManager() {
        this.tasks = new ArrayList<>();
    }

    List<Task> getTasks() {
        return tasks;
    }

    Task getTask(int taskNumber) {
        return tasks.get(taskNumber - 1);
    }

    void addTask(Task task) {
        tasks.add(task);
    }

    void markAsDone(int taskNumber) {
        tasks.get(taskNumber - 1).markAsDone();
    }
}
