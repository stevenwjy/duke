package duke.io;

import java.util.Optional;
import java.util.Scanner;

public class InputReader {
    private static String byeCommand = "bye";

    private Optional<String> buffer;
    private Scanner scanner;

    public InputReader() {
        this.buffer = Optional.empty();
        this.scanner = new Scanner(System.in);
    }

    private void refreshBuffer() {
        if (!buffer.isPresent() && scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (!command.equals(byeCommand)) {
                buffer = Optional.of(command);
            }
        }
    }

    public boolean hasNextCommand() {
        refreshBuffer();
        return buffer.isPresent();
    }

    public String nextCommand() {
        refreshBuffer();
        Optional<String> maybeCommand = buffer;
        buffer = Optional.empty();
        return maybeCommand.get();
    }
}
