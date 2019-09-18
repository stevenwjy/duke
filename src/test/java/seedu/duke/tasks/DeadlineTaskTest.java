package seedu.duke.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTaskTest {
    @Test
    public void toString_isNotDone_stringReturned() {
        String description = "example deadlineTask";
        String deadlineInfo = "next Monday";
        String expectedValue = "[D][X] " + description + " (by: " + deadlineInfo + ")";
        DeadlineTask deadlineTask = new DeadlineTask(description, deadlineInfo);

        assertEquals(expectedValue, deadlineTask.toString());
    }

    @Test
    public void toString_isDone_stringReturned() {
        String description = "example deadlineTask";
        String deadlineInfo = "next Monday";
        String expectedValue = "[D][O] " + description + " (by: " + deadlineInfo + ")";
        DeadlineTask deadlineTask = new DeadlineTask(description, deadlineInfo);
        deadlineTask.markAsDone();

        assertEquals(expectedValue, deadlineTask.toString());
    }

    @Test
    public void toString_timeFormat_stringReturned() {
        String description = "example deadlineTask";
        String deadlineInfo = "02/01/2019 22:10";
        String expectedValue = "[D][X] " + description + " (by: January 2, 2019, 10:10 PM)";
        DeadlineTask deadlineTask = new DeadlineTask(description, deadlineInfo);

        assertEquals(expectedValue, deadlineTask.toString());
    }
}
