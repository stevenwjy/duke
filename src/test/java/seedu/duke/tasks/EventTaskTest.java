package seedu.duke.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTaskTest {
    @Test
    public void toString_isNotDone_stringReturned() {
        String description = "example eventTask";
        String eventInfo = "random house";
        String expectedValue = "[E][X] " + description + " (at: " + eventInfo + ")";
        EventTask eventTask = new EventTask(description, eventInfo);

        assertEquals(expectedValue, eventTask.toString());
    }

    @Test
    public void toString_isDone_stringReturned() {
        String description = "example eventTask";
        String eventInfo = "random Monday";
        String expectedValue = "[E][O] " + description + " (at: " + eventInfo + ")";
        EventTask eventTask = new EventTask(description, eventInfo);
        eventTask.markAsDone();

        assertEquals(expectedValue, eventTask.toString());
    }
}
