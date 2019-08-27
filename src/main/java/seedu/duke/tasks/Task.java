package seedu.duke.tasks;

public abstract class Task {
    protected TaskType type;
    protected String description;
    protected boolean isDone;

    Task(TaskType type, String description) {
        this.type = type;
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    abstract String getAdditionalDescription();

    @Override
    public String toString() {
        return "[" + type.getTaskIcon() + "][" + getStatusIcon() + "] " + description + getAdditionalDescription();
    }
}
