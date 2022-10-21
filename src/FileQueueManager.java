public class FileQueueManager {
    protected static FileQueue createFileQueue(){
        FileQueue fileQueue = new FileQueue();
        fileQueue.addFileToQueue("LogFile1");
        fileQueue.addFileToQueue("LogFile2");
        return fileQueue;
    }
}
