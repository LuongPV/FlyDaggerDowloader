package mont.cristo.flydaggerdownloader.helpers.logger;

public abstract class BaseLogger implements Loggable {

    private StackTraceElement getCurrentStackTrace() {
        return Thread.currentThread().getStackTrace()[3];
    }

    /**
     * This method to get current log tag to find the current class run this log method
     * @return Log tag of current java class
     */
    protected String getLogTag() {
        String fileName = getCurrentStackTrace().getFileName();
        return fileName.substring(0, fileName.lastIndexOf(".") + 1);
    }

    /**
     * Get the method that invoke log method
     * @return Caller method name
     */
    protected String getMethodName() {
        return getCurrentStackTrace().getMethodName();
    }

    /**
     * Get process id that app currently running
     * @return Process id
     */
    protected int getProcessId() {
        return android.os.Process.myPid();
    }

    /**
     * Get thread id that app currently running
     * @return Thread id
     */
    protected long getThreadId() {
        return Thread.currentThread().getId();
    }

    /**
     * Get message has been optimized by adding process id, thread id, caller method name follow pattern:
     * Process[?]Thread[?][Method name] Message
     * @param message The original message
     * @return The optimized message
     */
    protected String getOptimizedMessage(String message) {
        return "Process[" + getProcessId() + "]Thread[" + getThreadId() + "][" + getMethodName() + "] " + message;
    }

}
