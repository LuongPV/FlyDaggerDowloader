package mont.cristo.flydaggerdownloader.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Any class want to be able to access database physical file, must implement this interface
 */
public interface DBAccessible {

    /**
     * Open database
     *
     * @return Accessible object to communicate with physical database file
     */
    SQLiteDatabase open();

    /**
     * Close current database connection
     */
    void close();

}
