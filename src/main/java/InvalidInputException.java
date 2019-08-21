public final class InvalidInputException extends RuntimeException {
    public enum Code {
        EMPTY_DONE_DESCRIPTION,
        EMPTY_DELETE_DESCRIPTION,
        INVALID_TASK_NUMBER,
        EMPTY_DEADLINE_DESCRIPTION,
        MISSING_DEADLINE_PARAMETER,
        EMPTY_EVENT_DESCRIPTION,
        MISSING_EVENT_PARAMETER,
        EMPTY_TODO_DESCRIPTION,
        UNKNOWN_COMMAND,
    }

    private Code code;

    InvalidInputException(Code code) {
        this.code = code;
    }

    public String errorDescription() {
        switch (code) {
            case EMPTY_DONE_DESCRIPTION:
                return "☹ OOPS!!! You must provide a task number for 'done' command!";
            case EMPTY_DELETE_DESCRIPTION:
                return "☹ OOPS!!! You must provide a task number for 'delete' command!";
            case INVALID_TASK_NUMBER:
                return "☹ OOPS!!! You entered an invalid task number!";
            case EMPTY_DEADLINE_DESCRIPTION:
                return "☹ OOPS!!! The description of a deadline cannot be empty.";
            case MISSING_DEADLINE_PARAMETER:
                return "☹ OOPS!!! The description of a deadline must contain ' /by '.";
            case EMPTY_EVENT_DESCRIPTION:
                return "☹ OOPS!!! The description of an event cannot be empty.";
            case MISSING_EVENT_PARAMETER:
                return "☹ OOPS!!! The description of an event must contain ' /at '.";
            case EMPTY_TODO_DESCRIPTION:
                return "☹ OOPS!!! The description of a todo cannot be empty.";
            case UNKNOWN_COMMAND:
                return "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
            default:
                break;
        }
        return null;
    }
}
