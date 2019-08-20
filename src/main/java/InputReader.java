import java.util.Optional;
import java.util.Scanner;

class InputReader {
    private static String byeCommand = "bye";

    private Optional<String> buffer;
    private Scanner scanner;

    InputReader() {
        this.buffer = Optional.empty();
        this.scanner = new Scanner(System.in);
    }

    private void refreshBuffer() {
        if (!buffer.isPresent() && scanner.hasNext()) {
            String command = scanner.next();
            if (!command.equals(byeCommand)) {
                buffer = Optional.of(command);
            }
        }
    }

    boolean hasNextCommand() {
        refreshBuffer();
        return buffer.isPresent();
    }

    String nextCommand() {
        refreshBuffer();
        Optional<String> maybeCommand = buffer;
        buffer = Optional.empty();
        return maybeCommand.get();
    }
}
