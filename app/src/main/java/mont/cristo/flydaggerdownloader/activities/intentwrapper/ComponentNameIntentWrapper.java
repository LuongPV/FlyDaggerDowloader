package mont.cristo.flydaggerdownloader.activities.intentwrapper;

import android.content.Context;
import android.content.Intent;

public abstract class ComponentNameIntentWrapper extends IntentWrapper {

    /**
     * Constructor to create new wrapper to get data (need for dest class)
     */
    public ComponentNameIntentWrapper(Intent intent) {
        super(intent);
    }

    /**
     * Constructor to create new wrapper to perform transport
     */
    protected ComponentNameIntentWrapper(Context context) {
        super(context);
    }

    /**
     * Provide destination class to create component name in an intent
     * @return Destination class that intent resolve to
     */
    public abstract Class<?> getDestClass();

}
