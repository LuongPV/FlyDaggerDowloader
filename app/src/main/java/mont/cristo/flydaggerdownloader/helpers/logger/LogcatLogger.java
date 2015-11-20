package mont.cristo.flydaggerdownloader.helpers.logger;

import android.util.Log;

/**
 * This class is used to write log to logcat
 */
public class LogcatLogger extends BaseLogger {

    @Override
    public void debug(String message) {
        Log.d(getLogTag(), getOptimizedMessage(message));
    }

    @Override
    public void warn(String message) {
        Log.w(getLogTag(), getOptimizedMessage(message));
    }
}
