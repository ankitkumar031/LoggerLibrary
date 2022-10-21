public class FatalLogger extends AbstractLogger{
    public FatalLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogLevel level, LogSink logSink){
        String message = "FATAL : " + msg;
        logSink.notifyAllObserver(level, message);
    }
}