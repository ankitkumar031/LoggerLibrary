public class InfoLogger extends AbstractLogger{
    public InfoLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogLevel level, LogSink logSink){
        String message = "INFO : " + msg;
        logSink.notifyAllObserver(level, message);
    }
}
