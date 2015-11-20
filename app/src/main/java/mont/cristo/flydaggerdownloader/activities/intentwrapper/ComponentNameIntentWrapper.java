package mont.cristo.flydaggerdownloader.activities.intentwrapper;

import android.content.Context;
import android.content.Intent;

public abstract class ComponentNameIntentWrapper extends IntentWrapper {
    protected Context context;

    public ComponentNameIntentWrapper(Intent intent) {
        super(intent);
    }

    public ComponentNameIntentWrapper(Context context) {
        this.context = context;
    }

    /**
     * Provide destination class to create component name in an intent
     * @return Destination class that intent resolve to
     */
    public abstract Class<?> getDestClass();

}
