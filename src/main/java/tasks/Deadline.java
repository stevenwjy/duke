package tasks;

public class Deadline extends Task {
    private String timeDescription;

    public Deadline(String description, String timeDescription) {
        super(TaskType.DEADLINE, description);
        this.timeDescription = timeDescription;
    }

    @Override
    String getAdditionalDescription() {
        return " (by: " + timeDescription + ")";
    }
}
