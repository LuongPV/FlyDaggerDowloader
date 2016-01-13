package mont.cristo.flydaggerdownloader.helpers.logger.base;

import android.support.annotation.NonNull;

import mont.cristo.flydaggerdownloader.helpers.logger.LoggerCreator;

public class Logger {

    @NonNull
    private static Loggable logger;

    static {
        // Must init default logger here
        logger = LoggerCreator.getLogger(LoggerCreator.LoggerType.LOGCAT);
    }

    public static void debug(String message) {
        // Delegate to real logger helper object
        logger.debug(message);
    }

    public static void warn(String message, Exception e) {
        // Delegate to real logger helper object
        logger.warn(message, e);
    }

}
