package seedu.duke.tasks;

import seedu.duke.tasks.exceptions.InvalidTaskException;

public abstract class Task {
    private TaskType type;
    private String description;
    private boolean isDone;

    /**
     * Constructor for <code>Task</code> object.
     *
     * @param type        Type of the task.
     * @param description Description of the task.
     * @param isDone      A boolean that indicates whether the task has been done or not.
     */
    Task(TaskType type, String description, boolean isDone) {
        this.type = type;
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Parser for Task object. It converts the <code>String</code> representation of a Task that is used to
     * store it in the database into a <code>Task</code> object.
     *
     * @param s A <code>String</code> representation of a <code>Task</code> which is stored in the file storage.
     * @return A <code>Task</code> object that corresponds to the <code>String</code>
     * @throws InvalidTaskException An error that causes failure in the parsing process, e.g. inconsistent format.
     */
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
