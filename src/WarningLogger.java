public class WarningLogger extends AbstractLogger{
    public WarningLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogLevel level, LogSink logSink){
        String message = "Warning : " + msg;
        logSink.notifyAllObserver(level, message);
    }
}