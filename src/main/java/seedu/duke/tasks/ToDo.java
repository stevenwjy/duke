package seedu.duke.tasks;

public class ToDo extends Task {
    /**
     * Constructor for <code>ToDo</code> that represents one of the possible task types.
     * By default, the task will not be marked as done upon initialization.
     *
     * @param description     Description of the <code>ToDo</code> task.
     */
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
