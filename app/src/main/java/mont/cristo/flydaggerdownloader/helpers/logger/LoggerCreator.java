package mont.cristo.flydaggerdownloader.helpers.logger;

import mont.cristo.flydaggerdownloader.helpers.logger.base.Loggable;
import mont.cristo.flydaggerdownloader.helpers.logger.file.FileLogger;
import mont.cristo.flydaggerdownloader.helpers.logger.logcat.LogcatLogger;

public class LoggerCreator {

    /**
     * All type of loggers should be defined here
     */
    public enum LoggerType {
        LOGCAT,
        FILE
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
            case FILE:
                logger = new FileLogger();
                break;
        }
        return logger;
    }

}
