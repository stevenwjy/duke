package seedu.duke.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTaskTest {
    @Test
    public void toString_isNotDone_stringReturned() {
        String description = "example todo";
        String expectedValue = "[T][X] " + description;
        ToDoTask toDoTask = new ToDoTask(description);

        assertEquals(expectedValue, toDoTask.toString());
    }

    @Test
    public void toString_isDone_stringReturned() {
        String description = "example todo";
        String expectedValue = "[T][O] " + description;
        ToDoTask toDoTask = new ToDoTask(description);
        toDoTask.markAsDone();

        assertEquals(expectedValue, toDoTask.toString());
    }
}
