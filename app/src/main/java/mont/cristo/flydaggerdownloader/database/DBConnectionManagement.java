package mont.cristo.flydaggerdownloader.database;

import android.database.sqlite.SQLiteDatabase;

public class DBConnectionManagement {

    /**
     * Control database connection.
     */
    private int referenceCount;

    /**
     * Real database object to access system database file
     */
    private SQLiteDatabase db;

    private DatabaseManager databaseManager;

    public DBConnectionManagement(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    /**
     * Safe to open database
     */
    public synchronized SQLiteDatabase open() {
        referenceCount++;
        if (db == null) {
            db = databaseManager.getWritableDatabase();
        }
        return db;
    }

    /**
     * Safe to close database
     */
    public synchronized void close() {
        referenceCount--;
        if (referenceCount <= 0 && db != null) {
            db.close();
            db = null;
        }
    }
}
