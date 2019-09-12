package seedu.duke.tasks;

import seedu.duke.tasks.exceptions.InvalidTaskException;

import java.util.Date;

public abstract class Task {
    private TaskType type;
    private String description;
    private boolean isDone;

    private Date createdAt;
    private Date updatedAt;

    /**
     * Constructor for <code>Task</code> object.
     *
     * @param type        Type of the task.
     * @param description Description of the task.
     * @param isDone      A boolean that indicates whether the task has been done or not.
     * @param createdAt   Creation time
     * @param updatedAt   Last update time
     */
    Task(TaskType type, String description, boolean isDone, Date createdAt, Date updatedAt) {
        this.type = type;
        this.description = description;
        this.isDone = isDone;

        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Parser for Task object. It converts the <code>String</code> representation of a Task that is used to
     * store it in the database into a <code>Task</code> object.
     *
     * @param str A <code>String</code> representation of a <code>Task</code> which is stored in the file storage.
     * @return A <code>Task</code> object that corresponds to the <code>String</code>
     * @throws InvalidTaskException An error that causes failure in the parsing process, e.g. inconsistent format.
     */
    static Task parseTask(String str) throws InvalidTaskException {
        return TaskParser.parseTask(str);
    }

    boolean equals(Task other) {
        return type == other.type && description.equals(other.description);
    }

    String getDescription() {
        return description;
    }

    public abstract String toString();

    abstract String getDataRepresentation();

    void markAsDone() {
        isDone = true;
        updatedAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    String getTaskIcon() {
        return type.getTaskIcon();
    }

    String getStatusIcon() {
        return (isDone ? "O" : "X");
    }
}
