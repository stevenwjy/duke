package seedu.duke.tasks;

import seedu.duke.tasks.exceptions.InvalidTaskException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class TaskParser {
    private static SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");

    static Task parseTask(String s) throws InvalidTaskException {
        String[] components = s.split(" \\| ", 5);
        if (components.length < 5) {
            throw new InvalidTaskException("Unsupported format of task representation in String, "
                    + "number of components: " + components.length);
        }

        boolean taskIsDone = parseTaskStatus(components[1]);
        Date creationDate = parseTaskDate(components[2]);
        Date updateDate = parseTaskDate(components[3]);

        if (components[0].equals(TaskType.TODO.getTaskIcon())) {
            return new ToDo(components[4], taskIsDone, creationDate, updateDate);

        } else if (components[0].equals(TaskType.DEADLINE.getTaskIcon())) {
            String[] deadlineInfo = components[4].split(" \\| ", 2);
            if (deadlineInfo.length < 2) {
                throw new InvalidTaskException("Invalid Deadline task format, doesn't contain time description");
            }
            return new Deadline(deadlineInfo[0], deadlineInfo[1], taskIsDone, creationDate, updateDate);

        } else if (components[0].equals(TaskType.EVENT.getTaskIcon())) {
            String[] eventInfo = components[4].split(" \\| ", 2);
            if (eventInfo.length < 2) {
                throw new InvalidTaskException("Invalid Event task format, doesn't contain time description");
            }
            return new Event(eventInfo[0], eventInfo[1], taskIsDone, creationDate, updateDate);

        } else {
            throw new InvalidTaskException("Unsupported task type: " + components[0]);
        }
    }

    private static boolean parseTaskStatus(String str) throws InvalidTaskException {
        switch (str) {
        case "X":
            return false;
        case "O":
            return true;
        default:
            throw new InvalidTaskException("Unsupported task completion status: " + str);
        }
    }

    private static Date parseTaskDate(String str) throws InvalidTaskException {
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            throw new InvalidTaskException("Invalid task date format: " + str);
        }
    }
}
