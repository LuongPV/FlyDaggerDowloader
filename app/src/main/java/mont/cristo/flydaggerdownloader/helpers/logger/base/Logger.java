package mont.cristo.flydaggerdownloader.helpers.logger.base;

import android.support.annotation.NonNull;

import mont.cristo.flydaggerdownloader.helpers.logger.LoggerCreator;

public class Logger {

    @NonNull
    private static Loggable[] loggers;

    static {
        // Must init default logger here
        loggers = new Loggable[]{LoggerCreator.getLogger(LoggerCreator.LoggerType.LOGCAT),
                LoggerCreator.getLogger(LoggerCreator.LoggerType.FILE)};
    }

    public static void debug(String message) {
        // Delegate to real logger helper object
        for (Loggable logger : loggers) {
            logger.debug(message);
        }
    }

    public static void warn(String message, Exception e) {
        // Delegate to real logger helper object
        for (Loggable logger : loggers) {
            logger.warn(message, e);
        }
    }

}
