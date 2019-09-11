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

    public Event(String description, String timeDescription, boolean done) {
        super(TaskType.EVENT, description, done);
        this.timeDescription = timeDescription;
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
