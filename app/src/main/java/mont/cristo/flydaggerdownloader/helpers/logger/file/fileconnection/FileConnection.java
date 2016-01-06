package mont.cristo.flydaggerdownloader.helpers.logger.file.fileconnection;

import android.os.Handler;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import mont.cristo.flydaggerdownloader.application.Application;

public class FileConnection implements Connect {
    private static final String TAG_LOG = FileConnection.class.getSimpleName();
    private static final String NAME_LOG_DIRECTORY = "log";
    private static final File FILE_LOG_DIRECTORY = Application.getInstance().getExternalFilesDir(NAME_LOG_DIRECTORY);
    private static final String FORMAT_TIME = "yyyyMMdd_HHmmss_SSS";
    private static final String EXTENSION = ".txt";

    /**
     * Time out for file connection. If in this time, don't have any log writing triggered, will close connection
     */
    private static final int TIME_OUT = 30000;

    /**
     * Max file size that a file can have. If exceed this size, must break to a new file
     */
    private static final int FILE_SIZE_MAX = 3145728;

    /**
     * File need to open connection
     */
    private String filePath;

    /**
     * Writer to file
     */
    private PrintWriter pw;
    private SimpleDateFormat formatter;
    private boolean isAutoFlush;
    private Handler handler;
    private Runnable taskDelayed;

    public FileConnection(boolean isAutoFlush) {
        this.isAutoFlush = isAutoFlush;
        formatter = new SimpleDateFormat(FORMAT_TIME, Locale.getDefault());
        handler = new Handler();
    }

    /**
     * Open connection to file
     * @return true if open file connection successfully
     */
    @Override
    public PrintWriter openConnection() {
        try {
            if (isFileSizeExceed()) {
                // File size has exceed allowed size. Must close and create new file
                if (pw != null) {
                    pw.close();
                }
                // Use current time to make file name
                filePath = FILE_LOG_DIRECTORY.getAbsolutePath() + formatter.format(new Date(System.currentTimeMillis())) + EXTENSION;
            }
            // Check connection is alive
            if (pw == null) {
                pw = new PrintWriter(new FileOutputStream(filePath), isAutoFlush);
            }
            startTimeOut();
        } catch (IOException e) {
            Log.e(TAG_LOG, "Exception: " + e);
        }
        return pw;
    }

    /**
     * Check file exceed allowed size to break file
     * @return true if file has exceeded its allowed size
     */
    private boolean isFileSizeExceed() {
        return new File(filePath).length() > FILE_SIZE_MAX;
    }

    /**
     * Start wait time out for current writing
     */
    private void startTimeOut() {
        // Remove previous delayed task
        handler.removeCallbacks(taskDelayed);
        taskDelayed = new Runnable() {
            @Override
            public void run() {
                pw.close();
                pw = null;
            }
        };
        // Wait time out
        handler.postDelayed(taskDelayed, TIME_OUT);
    }

    /**
     *  Refresh time out
     */
    public void refreshTime() {
        startTimeOut();
    }
}
