package seedu.duke.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void toString_isNotDone_stringReturned() {
        String description = "example deadline";
        String deadlineInfo = "next Monday";
        String expectedValue = "[D][\u2718] " + description + " (by: " + deadlineInfo + ")";
        Deadline deadline = new Deadline(description, deadlineInfo);

        assertEquals(expectedValue, deadline.toString());
    }

    @Test
    public void toString_isDone_stringReturned() {
        String description = "example deadline";
        String deadlineInfo = "next Monday";
        String expectedValue = "[D][\u2713] " + description + " (by: " + deadlineInfo + ")";
        Deadline deadline = new Deadline(description, deadlineInfo);
        deadline.markAsDone();

        assertEquals(expectedValue, deadline.toString());
    }

    @Test
    public void toString_timeFormat_stringReturned() {
        String description = "example deadline";
        String deadlineInfo = "02/01/2019 22:10";
        String expectedValue = "[D][\u2718] " + description + " (by: January 2, 2019, 10:10 PM)";
        Deadline deadline = new Deadline(description, deadlineInfo);

        assertEquals(expectedValue, deadline.toString());
    }
}
