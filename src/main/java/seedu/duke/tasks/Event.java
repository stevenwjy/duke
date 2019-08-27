package seedu.duke.tasks;

public class Event extends Task {
    private String timeDescription;

    public Event(String description, String timeDescription) {
        super(TaskType.EVENT, description);
        this.timeDescription = timeDescription;
    }

    @Override
    String getAdditionalDescription() {
        return " (at: " + timeDescription + ")";
    }
}
