package mont.cristo.flydaggerdownloader.application;

import mont.cristo.flydaggerdownloader.database.DatabaseManager;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initComponents();
    }

    /**
     * Initialize all required components
     */
    private void initComponents() {
        DatabaseManager.initialize(this);
    }
}
