package seedu.duke.tasks;

import java.util.Date;

public class ToDo extends Task {
    /**
     * Constructor for <code>ToDo</code> that represents one of the possible task types.
     *
     * @param description Description of the <code>ToDo</code> task.
     * @param isDone      A boolean that indicates whether a <code>ToDo</code> task has been done or not.
     * @param createdAt   Creation time
     * @param updatedAt   Last update time
     */
    ToDo(String description, boolean isDone, Date createdAt, Date updatedAt) {
        super(TaskType.TODO, description, isDone, createdAt, updatedAt);
    }

    /**
     * Convenient constructor for <code>ToDo</code> that represents one of the possible task types.
     *
     * @param description Description of the <code>ToDo</code> task.
     */
    public ToDo(String description) {
        super(TaskType.TODO, description, false, new Date(), new Date());
    }


    @Override
    public String toString() {
        return "[" + getTaskIcon() + "][" + getStatusIcon() + "] " + getDescription();
    }

    @Override
    String getDataRepresentation() {
        return getTaskIcon() + " | " + getStatusIcon() + " | " + getCreatedAt() + " | " + getUpdatedAt() + " | "
                + getDescription();
    }
}
