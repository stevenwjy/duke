package seedu.duke.tasks;

public class Event extends Task {
    private String timeDescription;

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
        return getTaskIcon() + " | " + (isDone() ? "1" : "0") + " | " + getDescription() + " | " + timeDescription;
    }
}
