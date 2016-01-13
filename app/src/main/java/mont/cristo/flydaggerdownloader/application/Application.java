package mont.cristo.flydaggerdownloader.application;

import mont.cristo.flydaggerdownloader.database.dbcore.DatabaseManager;

public class Application extends android.app.Application {
    private static Application instance;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initComponents();
        instance = this;
    }

    /**
     * Initialize all required components
     */
    private void initComponents() {
        DatabaseManager.initialize(this);
    }
}
