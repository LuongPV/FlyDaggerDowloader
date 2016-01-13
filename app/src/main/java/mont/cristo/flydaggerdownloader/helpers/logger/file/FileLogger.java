package mont.cristo.flydaggerdownloader.helpers.logger.file;

import android.util.Log;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import mont.cristo.flydaggerdownloader.helpers.logger.base.BaseLogger;
import mont.cristo.flydaggerdownloader.helpers.logger.file.fileconnection.FileConnection;

/**
 * This class is used to write log to logcat
 */
public class FileLogger extends BaseLogger {
    private static final boolean IS_AUTO_FLUSH = false;
    private FileConnection fileConnection;
    private static final String FORMAT_TIME = "yyyyMMdd:HHmmss:SSS";
    private SimpleDateFormat formatter;

    public FileLogger() {
        formatter = new SimpleDateFormat(FORMAT_TIME, Locale.getDefault());
        fileConnection = new FileConnection(IS_AUTO_FLUSH);
    }

    @Override
    public void debug(String message) {
        PrintWriter fileConnection = this.fileConnection.openConnection();
        if (fileConnection != null) {
            fileConnection.println("[" + formatter.format(new Date(System.currentTimeMillis())) + "]" + "[Debug]" + getOptimizedMessage(message));
            // Every file has written, must refresh time out
            this.fileConnection.refreshTime();
        } else {
            Log.e(getLogTag(), "[debug] Cannot open file connection");
        }
    }

    @Override
    public void warn(String message, Exception e) {
        PrintWriter fileConnection = this.fileConnection.openConnection();
        if (fileConnection != null) {
            fileConnection.println("[" + formatter.format(new Date(System.currentTimeMillis())) + "]" + "[Warn]" + getOptimizedWarning(message, e));
            // Every file has written, must refresh time out
            this.fileConnection.refreshTime();
        } else {
            Log.e(getLogTag(), "[warn] Cannot open file connection");
        }
    }

}
