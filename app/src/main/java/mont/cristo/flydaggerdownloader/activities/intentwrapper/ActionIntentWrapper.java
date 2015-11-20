package mont.cristo.flydaggerdownloader.activities.intentwrapper;

public abstract class ActionIntentWrapper extends IntentWrapper {
    protected String action;

    /**
     * Constructor to create new wrapper base on an action (need for source class)
     */
    protected ActionIntentWrapper(String action) {
        this.action = action;
    }

    /**
     * Sub-class must provide action to resolve an intent
     * @return An action string that intent resolve to
     */
    public abstract String getAction();

}
