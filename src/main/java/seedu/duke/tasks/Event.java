package seedu.duke.tasks;

public class Event extends Task {
    private String timeDescription;

    /**
     * Constructor for <code>Event</code> that represents one of the possible task types.
     * By default, the task will not be marked as done upon initialization.
     *
     * @param description     Description of the <code>Event</code> task.
     * @param timeDescription An information regarding the event.
     */
    public Event(String description, String timeDescription) {
        super(TaskType.EVENT, description, false);
        this.timeDescription = timeDescription;
    }

    /**
     * Constructor for <code>Event</code> that represents one of the possible task types.
     *
     * @param description     Description of the <code>Event</code> task.
     * @param timeDescription An information regarding the event.
     * @param isDone          A boolean that indicates whether an <code>Event</code> task has been done or not.
     */
    Event(String description, String timeDescription, boolean isDone) {
        super(TaskType.EVENT, description, isDone);
        this.timeDescription = timeDescription;
    }

    @Override
    boolean equals(Task other) {
        if (!super.equals(other)) {
            return false;
        }
        Event otherEvent = (Event) other;
        return timeDescription.equals(otherEvent.timeDescription);
    }

    @Override
    public String toString() {
        return "[" + getTaskIcon() + "][" + getStatusIcon() + "] "
                + getDescription() + " (at: " + timeDescription + ")";
    }

    @Override
    String getDataRepresentation() {
        return getTaskIcon() + " | " + getStatusIcon() + " | " + getDescription() + " | " + timeDescription;
    }
}
