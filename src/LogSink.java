import java.util.*;

public class LogSink {
    Map<LogLevel, List<LogObserver>> logObservers = new HashMap<>();

    void addObserver(LogLevel level, LogObserver logObserver) {
        List<LogObserver> logObserverList = logObservers.getOrDefault(level, new ArrayList<>());
        logObserverList.add(logObserver);

        logObservers.put(level, logObserverList);
    }

    void notifyAllObserver(LogLevel level, String msg) {
        for(Map.Entry<LogLevel, List<LogObserver>> entry: logObservers.entrySet()) {
            if(entry.getKey() == level) entry.getValue().forEach(observer -> observer.log(level, msg));
        }
    }
}
