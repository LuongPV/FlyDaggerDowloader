package mont.cristo.flydaggerdownloader.helpers.logger.logcat;

import android.util.Log;

import mont.cristo.flydaggerdownloader.helpers.logger.BaseLogger;

/**
 * This class is used to write log to logcat
 */
public class LogcatLogger extends BaseLogger {

    @Override
    public void debug(String message) {
        Log.d(getLogTag(), getOptimizedMessage(message));
    }

    @Override
    public void warn(String message, Exception e) {
        Log.w(getLogTag(), getOptimizedWarning(message, e));
    }
}
