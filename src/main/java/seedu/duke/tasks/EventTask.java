package seedu.duke.tasks;

import java.util.Date;

public class EventTask extends Task {
    private String timeDescription;

    /**
     * Constructor for <code>EventTask</code> that represents one of the possible task types.
     * By default, the task will not be marked as done upon initialization.
     *
     * @param description     Description of the <code>EventTask</code> task.
     * @param timeDescription An information regarding the event.
     * @param isDone          A boolean that indicates whether an <code>EventTask</code> task has been done or not.
     * @param createdAt       Creation time
     * @param updatedAt       Last update time
     */
    EventTask(String description, String timeDescription, boolean isDone, Date createdAt, Date updatedAt) {
        super(TaskType.EVENT, description, isDone, createdAt, updatedAt);
        this.timeDescription = timeDescription;
    }

    /**
     * Convenient constructor for <code>EventTask</code> that represents one of the possible task types.
     *
     * @param description     Description of the <code>EventTask</code> task.
     * @param timeDescription An information regarding the event.
     */
    public EventTask(String description, String timeDescription) {
        this(description, timeDescription, false, new Date(), new Date());
    }

    @Override
    boolean equals(Task other) {
        if (!super.equals(other)) {
            return false;
        }
        EventTask otherEventTask = (EventTask) other;
        return timeDescription.equals(otherEventTask.timeDescription);
    }

    @Override
    public String toString() {
        return "[" + getTaskIcon() + "][" + getStatusIcon() + "] "
                + getDescription() + " (at: " + timeDescription + ")";
    }

    @Override
    String getDataRepresentation() {
        return getTaskIcon() + " | " + getStatusIcon() + " | " + getCreatedAt() + " | " + getUpdatedAt() + " | "
                + getDescription() + " | " + timeDescription;
    }
}
