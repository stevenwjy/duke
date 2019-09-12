package seedu.duke.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Deadline extends Task {
    private String timeDescription;

    /**
     * Constructor for <code>Deadline</code> that represents one of the possible task types.
     * By default, the task will not be marked as done upon initialization.
     *
     * @param description     Description of the <code>Deadline</code> task.
     * @param timeDescription An information that specifies the deadline of the task.
     */
    public Deadline(String description, String timeDescription) {
        super(TaskType.DEADLINE, description, false);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter targetFormatter = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT);

        if (timeDescription.matches("[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}:[0-9]{2}")) {
            try {
                this.timeDescription = LocalDateTime.parse(timeDescription, formatter).format(targetFormatter);
            } catch (Exception e) {
                this.timeDescription = timeDescription;
            }
        } else {
            this.timeDescription = timeDescription;
        }
    }

    /**
     * Constructor for <code>Event</code> that represents one of the possible task types.
     *
     * @param description     Description of the <code>Event</code> task.
     * @param timeDescription An information regarding the event.
     * @param isDone          A boolean that indicates whether a <code>Deadline</code> task has been done or not.
     */
    Deadline(String description, String timeDescription, boolean isDone) {
        super(TaskType.DEADLINE, description, isDone);
        this.timeDescription = timeDescription;
    }

    @Override
    boolean equals(Task other) {
        if (!super.equals(other)) {
            return false;
        }
        Deadline otherDeadline = (Deadline) other;
        return timeDescription.equals(otherDeadline.timeDescription);
    }

    @Override
    public String toString() {
        return "[" + getTaskIcon() + "][" + getStatusIcon() + "] "
                + getDescription() + " (by: " + timeDescription + ")";
    }

    @Override
    String getDataRepresentation() {
        return getTaskIcon() + " | " + getStatusIcon() + " | " + getDescription() + " | " + timeDescription;
    }
}
