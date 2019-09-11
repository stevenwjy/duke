package seedu.duke.tasks;

import seedu.duke.tasks.exceptions.InvalidTaskException;

public abstract class Task {
    private TaskType type;
    private String description;
    private boolean isDone;

    Task(TaskType type, String description, boolean isDone) {
        this.type = type;
        this.description = description;
        this.isDone = isDone;
    }

    static Task parseTask(String s) throws InvalidTaskException {
        String[] components = s.split(" \\| ", 3);
        if (components.length < 3) {
            throw new InvalidTaskException("Unsupported format of task representation in String, "
                    + "number of components: " + components.length);
        }

        boolean taskIsDone;
        switch (components[1]) {
        case "X":
            taskIsDone = false;
            break;
        case "O":
            taskIsDone = true;
            break;
        default:
            throw new InvalidTaskException("Unsupported task completion status: " + components[1]);
        }

        switch (components[0]) {
        case "T":
            return new ToDo(components[2], taskIsDone);
        case "D":
            String[] deadlineInfo = components[2].split(" \\| ", 2);
            if (deadlineInfo.length < 2) {
                throw new InvalidTaskException("Invalid Deadline task format, doesn't contain time description");
            }
            return new Deadline(deadlineInfo[0], deadlineInfo[1], taskIsDone);
        case "E":
            String[] eventInfo = components[2].split(" \\| ", 2);
            if (eventInfo.length < 2) {
                throw new InvalidTaskException("Invalid Event task format, doesn't contain time description");
            }
            return new Event(eventInfo[0], eventInfo[1], taskIsDone);
        default:
            throw new InvalidTaskException("Unsupported task type: " + components[0]);
        }
    }

    String getDescription() {
        return description;
    }

    public abstract String toString();

    abstract String getDataRepresentation();

    void markAsDone() {
        this.isDone = true;
    }

    String getTaskIcon() {
        return type.getTaskIcon();
    }

    String getStatusIcon() {
        return (isDone ? "O" : "X");
    }
}
