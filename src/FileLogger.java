import Utility.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LogObserver{
    FileQueue fileQueue;

    public FileLogger(FileQueue fileQueue) {
        this.fileQueue = fileQueue;
    }

    @Override
    public void log(LogLevel level, String msg) {
        String date = utility.convertCurrentDateTimeToFormatSpecified("dd/MM/YYYY hh:mm:ss");
        String fileName = fileQueue.obtainFileFromQueueToAddFileLogs();
        String directoryName = Constants.LogFilesPath;

        String message = "{ts_format:" + date + "\nsink_type:" + SinkType.FILE +
                        "\nfile_location:" + directoryName+fileName+".txt" + "\nlog_level:" + level +
                        "\n" + msg + "}";

        boolean success = writeToFile(directoryName, fileName, message);
        if(success) System.out.println("SUCCESSFULLY WRITTEN TO THE FILE, Pump Success Metric");
        else System.out.println("Prohibited Writing TO THE FILE, Pump Failure Metric");
    }

    private boolean writeToFile(String directoryName, String fileName, String msg) {
        File directory = new File(directoryName);

        if (!directory.exists()){
            directory.mkdirs();
        }
        try
        {
            File file = new File(directoryName + fileName);
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true); //the true will append the new data
            fw.write(msg+'\n');
            fw.close();

            return true;
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
            return false;
        }
    }
}