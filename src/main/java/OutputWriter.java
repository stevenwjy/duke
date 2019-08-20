class OutputWriter {
    private static String line = "    ____________________________________________________________";
    private static String header = "Hello! I'm Duke\n" + "     What can I do for you?";
    private static String footer = "Bye. Hope to see you again soon!";
    private static String tab = "     ";

    void printHeader() {
        System.out.println(line);
        System.out.println(tab + header);
        System.out.println(line);
    }

    void printFooter() {
        System.out.println(line);
        System.out.println(tab + footer);
        System.out.println(line);
    }

    void handleCommand(String command) {
        System.out.println(line);
        System.out.println(tab + command);
        System.out.println(line);
    }
}
