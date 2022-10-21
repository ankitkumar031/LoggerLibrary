public class LogManager {
    protected static AbstractLogger buildChainOfLogger() {
        AbstractLogger infoLogger = new InfoLogger(LogLevel.INFO);
        AbstractLogger errorLogger = new ErrorLogger(LogLevel.ERROR);
        AbstractLogger debugLogger = new DebugLogger(LogLevel.DEBUG);
        AbstractLogger warningLogger = new WarningLogger(LogLevel.WARN);
        AbstractLogger fatalLogger = new FatalLogger(LogLevel.FATAL);

        infoLogger.setNextLoggingLevel(errorLogger);
        errorLogger.setNextLoggingLevel(debugLogger);
        debugLogger.setNextLoggingLevel(warningLogger);
        warningLogger.setNextLoggingLevel(fatalLogger);

        return infoLogger;
    }

    protected static LogSink buildLogSink(){
        LogSink logSink = new LogSink();
        ConsoleLogger consoleLogger = new ConsoleLogger();

        FileQueue fileQueue = FileQueueManager.createFileQueue();
        FileLogger fileLogger = new FileLogger(fileQueue);

        logSink.addObserver(LogLevel.INFO, consoleLogger);
        logSink.addObserver(LogLevel.ERROR, consoleLogger);
        logSink.addObserver(LogLevel.DEBUG, consoleLogger);
        logSink.addObserver(LogLevel.WARN, consoleLogger);
        logSink.addObserver(LogLevel.FATAL, consoleLogger);

        logSink.addObserver(LogLevel.ERROR, fileLogger);
        logSink.addObserver(LogLevel.DEBUG, fileLogger);
        logSink.addObserver(LogLevel.FATAL, fileLogger);

        return logSink;
    }
}
