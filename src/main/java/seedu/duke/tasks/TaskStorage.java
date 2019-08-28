package seedu.duke.tasks;

import seedu.duke.tasks.exceptions.InvalidTaskException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class TaskStorage {
    private File file;

    TaskStorage(String filePath) throws IOException {
        this.file = new File(filePath);

        File directory = new File(String.valueOf(Path.of(filePath).getParent()));
        if (!directory.isDirectory()) {
            directory.mkdirs();
        }

        if (!file.isFile()) {
            file.createNewFile();
        }
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
