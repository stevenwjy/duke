package seedu.duke.tasks;

public enum TaskType {
    TODO,
    DEADLINE,
    EVENT;

    String getTaskIcon() {
        switch (this) {
        case TODO:
            return "T";
        case DEADLINE:
            return "D";
        case EVENT:
            return "E";
        }
        return null;
    }
}
