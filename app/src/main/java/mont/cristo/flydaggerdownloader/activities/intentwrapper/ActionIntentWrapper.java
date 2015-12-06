package mont.cristo.flydaggerdownloader.activities.intentwrapper;

import android.content.Context;
import android.content.Intent;

public abstract class ActionIntentWrapper extends IntentWrapper {

    /**
     * Constructor to create new wrapper to get data (need for dest class)
     */
    public ActionIntentWrapper(Intent intent) {
        super(intent);
    }

    /**
     * Constructor to create new wrapper to perform transport
     */
    protected ActionIntentWrapper(Context context) {
        super(context);
    }

    /**
     * Sub-class must provide action to resolve an intent
     * @return An action string that intent resolve to
     */
    public abstract String getAction();

}
