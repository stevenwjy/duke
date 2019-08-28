package seedu.duke.tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskStorage {
    private File file;

    TaskStorage(String filePath) {
        this.file = new File(filePath);
    }

    List<Task> loadTasks() throws IOException, InvalidTaskException {
        List<Task> tasks = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            Task task = Task.parseTask(line);
            tasks.add(task);
        }

        return tasks;
    }

    void saveTasks(List<Task> tasks) throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);

        for (Task task : tasks) {
            printWriter.println(task.getDataRepresentation());
        }

        printWriter.close();
    }
}
