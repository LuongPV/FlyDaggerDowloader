package mont.cristo.flydaggerdownloader.helpers.logger.base;

public abstract class BaseLogger implements Loggable {
    private static final int INDEX_STACK_TRACE_DEFAULT = 3;

    /**
     * This method to get current log tag to find the current class run this log method
     *
     * @return Log tag of current java class
     */
    protected String getLogTag() {
        String fileName = Thread.currentThread().getStackTrace()[INDEX_STACK_TRACE_DEFAULT].getFileName();
        return fileName.substring(0, fileName.lastIndexOf(".") + 1);
    }

    /**
     * Get the method that invoke log method
     *
     * @return Caller method name
     */
    protected String getMethodName(int countMethod) {
        StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
        // File the maximum method can shown
        int maxIndexShownMethod = countMethod + INDEX_STACK_TRACE_DEFAULT;
        if (stackTraces.length <= maxIndexShownMethod) {
            maxIndexShownMethod = stackTraces.length - 1;
        }
        String methodName = "";
        for (int i = maxIndexShownMethod; i >= INDEX_STACK_TRACE_DEFAULT; i--) {
            methodName += stackTraces[i].getMethodName() + " >>> ";
        }
        return methodName;
    }

    /**
     * Get process id that app currently running
     *
     * @return Process id
     */
    protected int getProcessId() {
        return android.os.Process.myPid();
    }

    /**
     * Get thread id that app currently running
     *
     * @return Thread id
     */
    protected long getThreadId() {
        return Thread.currentThread().getId();
    }

    /**
     * Get message has been optimized by adding process id, thread id, caller method name follow pattern:
     * Process[?]Thread[?][Method name] Message
     *
     * @param message The original message
     * @return The optimized message
     */
    protected String getOptimizedMessage(String message) {
        return getOptimizedMessage(message, 0);
    }

    /**
     * The same as getOptimizedMessage but can use numberMethod optional to show more call method order from call stack
     *
     * @param numberMethod Number method need to show more
     */
    protected String getOptimizedMessage(String message, int numberMethod) {
        return "Process-" + getProcessId() + " >>> Thread-" + getThreadId() + " >>> " + getMethodName(numberMethod) + message;
    }

    /**
     * Get warning message has been optimized by adding process id, thread id, caller method name follow pattern:
     * Process[?]Thread[?][Method name] Message | Exception ?
     *
     * @param message The original message
     * @param e       Detailed exception
     * @return The optimized message
     */
    protected String getOptimizedWarning(String message, Exception e) {
        return getOptimizedWarning(message, e, 0);
    }

    /**
     * The same as getOptimizedWarning but can use numberMethod optional to show more call method order from call stack
     *
     * @param numberMethod Number method need to show more
     */
    protected String getOptimizedWarning(String message, Exception e, int numberMethod) {
        return getOptimizedMessage(message, numberMethod) + " >>> " + "Exception: " + e;
    }

}
