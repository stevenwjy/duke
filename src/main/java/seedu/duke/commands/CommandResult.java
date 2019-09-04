package seedu.duke.commands;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {
    public final String feedbackToUser;

    CommandResult(String feedbackToUser) {
        assert feedbackToUser != null;
        this.feedbackToUser = feedbackToUser;
    }
}
