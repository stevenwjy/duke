package seedu.duke.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Deadline extends Task {
    private String timeDescription;

    public Deadline(String description, String timeDescription) {
        super(TaskType.DEADLINE, description);

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

    @Override
    String getAdditionalDescription() {
        return " (by: " + timeDescription + ")";
    }
}
