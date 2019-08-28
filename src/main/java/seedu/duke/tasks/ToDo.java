package seedu.duke.tasks;

public class ToDo extends Task {
    public ToDo(String description) {
        super(TaskType.TODO, description, false);
    }

    public ToDo(String description, boolean done) {
        super(TaskType.TODO, description, done);
    }

    @Override
    public String toString() {
        return "[" + getTaskIcon() + "][" + getStatusIcon() + "] " + getDescription();
    }

    @Override
    String getDataRepresentation() {
        return getTaskIcon() + " | " + (isDone() ? "1" : "0") + " | " + getDescription();
    }
}
