package mont.cristo.flydaggerdownloader.activities.intentwrapper;

import android.content.Intent;

/**
 * Sub-class can extend this class to define an intent wrapper that contain source, dest, extra bundle data...
 */
public abstract class IntentWrapper {

    /**
     * Intent that destination class can use to get their data
     */
    protected Intent intent;

    protected IntentWrapper() {

    }

    /**
     * Constructor to create new wrapper to get data (need for dest class)
     */
    protected IntentWrapper(Intent intent) {
        this.intent = intent;
    }

    /**
     * Concrete intent wrapper must use this method to add their data into intent and start another component
     */
    public abstract void transport();

}
