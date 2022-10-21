public abstract class AbstractLogger {
    LogLevel level;
    AbstractLogger nextLoggingLevel;

    public void setNextLoggingLevel(AbstractLogger nextLoggingLevel) {
        this.nextLoggingLevel = nextLoggingLevel;
    }

    public void logMessage( String msg, LogLevel level, LogSink logSink) {
        if(this.level == level) display(msg, level, logSink);
        if(nextLoggingLevel != null) nextLoggingLevel.logMessage(msg, level, logSink);
    }

    protected abstract void display(String msg, LogLevel level, LogSink logSink);
}
