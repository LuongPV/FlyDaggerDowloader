package mont.cristo.flydaggerdownloader.helpers.logger;

/**
 * Define methods needed for any concrete log object
 */
public interface Loggable {

    /**
     * Show debug log that will show information to trace flow
     *
     * @param message Message need to show
     */
    void debug(String message);

    /**
     * Show warning log that will show detailed for caught error log
     *
     * @param message Message need to show
     * @param e       Detailed exception
     */
    void warn(String message, Exception e);

}
