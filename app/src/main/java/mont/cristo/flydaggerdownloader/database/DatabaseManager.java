package mont.cristo.flydaggerdownloader.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mont.cristo.flydaggerdownloader.database.dao.DAO;
import mont.cristo.flydaggerdownloader.database.dao.DAOCreator;
import mont.cristo.flydaggerdownloader.helpers.logger.Logger;

public class DatabaseManager extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 7;

    // Database Name
    public static final String DATABASE_NAME = "fly_dagger_downloader.sqlite";

    /**
     * Singleton to hold the unique instance
     */
    private static DatabaseManager instance;

    /**
     * Database connection management object
     */
    private DBConnectionManagement dbConnection;

    /**
     * Use single instance for this class
     */
    public static DatabaseManager initialize(Context context) {
        if (instance == null) {
            instance = new DatabaseManager(context);
        }
        return instance;
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // Init connection management
        dbConnection = new DBConnectionManagement(this);
        initDatabase();
    }

    private void initDatabase() {

        // Open connection to invoke onCreate, onUpgrade lifecycle
        dbConnection.open();

        // Close connection
        dbConnection.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Init all table by its DAO helper
        createAllTable();
        Logger.debug("Done init all DAO tables");
    }

    private void createAllTable() {
        SQLiteDatabase db = null;
        try {
            db = dbConnection.open();
            for (DAO dao : DAOCreator.getAllDAO(db)) {
                dao.initTable();
            }
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        deleteAllTable();
        Logger.debug("Done delete or modify table structure");

        // Re-create db
        onCreate(db);
    }

    private void deleteAllTable() {
        SQLiteDatabase db = null;
        try {
            db = dbConnection.open();
            for (DAO dao : DAOCreator.getAllDAO(db)) {
                dao.deleteTable();
            }
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    /**
     * Bad code structure, need optimize
     */
    public void execSQL(String sql) {
        SQLiteDatabase db = null;
        try {
            db = dbConnection.open();
            db.execSQL(sql);
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    /**
     * Bad code structure, need optimize
     */
    public SQLiteDatabase openConnection() {
        return dbConnection.open();
    }

    /**
     * Bad code structure, need optimize
     */
    public void closeConnection() {
        dbConnection.close();
    }
}
