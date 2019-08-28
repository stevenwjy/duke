package seedu.duke.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void toString_isNotDone_stringReturned() {
        String description = "example event";
        String eventInfo = "random house";
        String expectedValue = "[E][\u2718] " + description + " (at: " + eventInfo + ")";
        Event event = new Event(description, eventInfo);

        assertEquals(expectedValue, event.toString());
    }

    @Test
    public void toString_isDone_stringReturned() {
        String description = "example event";
        String eventInfo = "random Monday";
        String expectedValue = "[E][\u2713] " + description + " (at: " + eventInfo + ")";
        Event event = new Event(description, eventInfo);
        event.markAsDone();

        assertEquals(expectedValue, event.toString());
    }
}
