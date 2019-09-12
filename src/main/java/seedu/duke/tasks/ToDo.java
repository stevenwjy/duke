package seedu.duke.tasks;

public class ToDo extends Task {
    /**
     * Constructor for <code>ToDo</code> that represents one of the possible task types.
     * By default, the task will not be marked as done upon initialization.
     *
     * @param description Description of the <code>ToDo</code> task.
     */
    public ToDo(String description) {
        super(TaskType.TODO, description, false);
    }

    /**
     * Constructor for <code>ToDo</code> that represents one of the possible task types.
     *
     * @param description Description of the <code>Event</code> task.
     * @param isDone      A boolean that indicates whether a <code>ToDo</code> task has been done or not.
     */
    public ToDo(String description, boolean isDone) {
        super(TaskType.TODO, description, isDone);
    }

    @Override
    public String toString() {
        return "[" + getTaskIcon() + "][" + getStatusIcon() + "] " + getDescription();
    }

    @Override
    String getDataRepresentation() {
        return getTaskIcon() + " | " + getStatusIcon() + " | " + getDescription();
    }
}
