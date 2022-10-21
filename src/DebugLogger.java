public class DebugLogger extends AbstractLogger{
    public DebugLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogLevel level, LogSink logSink){
        String message = "DEBUG : " + msg;
        logSink.notifyAllObserver(level, message);
    }
}