package mont.cristo.flydaggerdownloader.application;

import mont.cristo.flydaggerdownloader.database.manager.base.Database;
import mont.cristo.flydaggerdownloader.database.manager.base.DBCreator;

public class Application extends android.app.Application {
    private static Application instance;
    private Database database;

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
        database = DBCreator.getDatabase(DBCreator.DatabaseType.REALM, this);
    }

    public Database getDatabase() {
        return database;
    }
}
