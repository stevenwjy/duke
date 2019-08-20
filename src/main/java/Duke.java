public class Duke {
    private static InputReader inputReader;
    private static OutputWriter outputWriter;

    public static void main(String[] args) {
        inputReader = new InputReader();
        outputWriter = new OutputWriter();

        run();
    }

    private static void run() {
        outputWriter.printHeader();
        while (inputReader.hasNextCommand()) {
            String command = inputReader.nextCommand();
            outputWriter.handleCommand(command);
        }
        outputWriter.printFooter();
    }
}
