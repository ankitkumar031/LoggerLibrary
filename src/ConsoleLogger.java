import Utility.utility;

public class ConsoleLogger implements LogObserver{
    @Override
    public void log(LogLevel level, String msg) {
        System.out.println("log_level:"+level + ",sink_type:"+ SinkType.CONSOLE + ",message:" + msg);
    }
}
