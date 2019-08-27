package duke.io;

public final class InvalidInputException extends Exception {
    public enum Code {
        EMPTY_DONE_DESCRIPTION("You must provide a task number for 'done' command!"),
        EMPTY_DELETE_DESCRIPTION( "You must provide a task number for 'delete' command!"),
        INVALID_TASK_NUMBER("You entered an invalid task number!"),
        EMPTY_DEADLINE_DESCRIPTION("The description of a deadline cannot be empty."),
        MISSING_DEADLINE_PARAMETER( "The description of a deadline must contain ' /by '."),
        EMPTY_EVENT_DESCRIPTION("The description of an event cannot be empty."),
        MISSING_EVENT_PARAMETER("The description of an event must contain ' /at '."),
        EMPTY_TODO_DESCRIPTION("The description of a todo cannot be empty."),
        UNKNOWN_COMMAND("I'm sorry, but I don't know what that means :-(");

        private String message;

        Code(String message) {
            this.message = message;
        }

        public String getMessage() {
            return "☹ OOPS!!! " + this.message;
        }
    }

    private Code code;

    public InvalidInputException(Code code) {
        super(code.getMessage());
    }
}
