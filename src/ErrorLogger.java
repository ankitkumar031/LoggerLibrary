public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogLevel level, LogSink logSink){
        String message = "ERROR : " + msg;
        logSink.notifyAllObserver(level, message);
    }
}
