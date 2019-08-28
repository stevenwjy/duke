package seedu.duke.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void toString_isNotDone_stringReturned() {
        String description = "example todo";
        String expectedValue = "[T][\u2718] " + description;
        ToDo toDo = new ToDo(description);

        assertEquals(expectedValue, toDo.toString());
    }

    @Test
    public void toString_isDone_stringReturned() {
        String description = "example todo";
        String expectedValue = "[T][\u2713] " + description;
        ToDo toDo = new ToDo(description);
        toDo.markAsDone();

        assertEquals(expectedValue, toDo.toString());
    }
}
