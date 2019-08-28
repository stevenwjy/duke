package seedu.duke.tasks;

public class Deadline extends Task {
    private String timeDescription;

    public Deadline(String description, String timeDescription) {
        super(TaskType.DEADLINE, description, false);
        this.timeDescription = timeDescription;
    }

    public Deadline(String description, String timeDescription, boolean done) {
        super(TaskType.DEADLINE, description, done);
        this.timeDescription = timeDescription;
    }

    @Override
    public String toString() {
        return "[" + getTaskIcon() + "][" + getStatusIcon() + "] " +
                getDescription() + " (by: " + timeDescription + ")";
    }

    @Override
    String getDataRepresentation() {
        return getTaskIcon() + " | " + (isDone() ? "1" : "0") + " | " + getDescription() + " | " + timeDescription;
    }
}
