import java.io.Serializable;
public class Logger implements Cloneable, Serializable{
    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LogSink logSink;

    private Logger() {
        if(logger != null) {
            throw new IllegalStateException("Object Already Exists");
        }
    }

    public static Logger getInstance() {
        if(logger == null) {
            synchronized(Logger.class) {
                if(logger == null) {
                    logger = new Logger();
                    chainOfLogger = LogManager.buildChainOfLogger();
                    logSink = LogManager.buildLogSink();
                }
            }
        }
        return logger;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private void createLog(LogLevel level, String msg) {
        chainOfLogger.logMessage(msg, level, logSink);
    }

    public void info(String msg){
        createLog(LogLevel.INFO, msg);
    }

    public void error(String msg){
        createLog(LogLevel.ERROR, msg);
    }

    public void debug(String msg){
        createLog(LogLevel.DEBUG, msg);
    }
    public void warning(String msg){
        createLog(LogLevel.WARN, msg);
    }
    public void fatal(String msg){
        createLog(LogLevel.FATAL, msg);
    }
}
