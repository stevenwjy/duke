package tasks;

public class ToDo extends Task {
    public ToDo(String description) {
        super(TaskType.TODO, description);
    }

    @Override
    String getAdditionalDescription() {
        return "";
    }
}
