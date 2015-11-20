package mont.cristo.flydaggerdownloader.helpers.logger;

public class LoggerCreator {

    /**
     * All type of loggers should be defined here
     */
    public enum LoggerType {
        LOGCAT
    }

    /**
     * Get real logger
     * @param loggerType Type of log need to get
     * @return Real logger object or null if not found match with logger type
     */
    public static Loggable getLogger(LoggerType loggerType) {
        Loggable logger = null;
        switch (loggerType) {
            case LOGCAT:
                logger = new LogcatLogger();
                break;
        }
        return logger;
    }

}
