import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class FileQueue {
    Queue<String> fileQueue = new LinkedList<>();

    void addFileToQueue(String filename) {
        fileQueue.add(filename);
    }

    void removeFileToQueue() {
        String fileName = fileQueue.remove();
        System.out.println("File removed From Queue: " + fileName);
    }

    String obtainFileFromQueueToAddFileLogs() {
        String fileName = fileQueue.peek();
        removeFileToQueue();
        fileQueue.add(fileName);

        return fileName;
    }
}
