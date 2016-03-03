package mont.cristo.flydaggerdownloader.database.manager.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mont.cristo.flydaggerdownloader.database.dao.sqlite.DAO;
import mont.cristo.flydaggerdownloader.database.dao.sqlite.DAOCreator;
import mont.cristo.flydaggerdownloader.database.manager.base.Database;
import mont.cristo.flydaggerdownloader.helpers.logger.base.Logger;

public class DBManager extends SQLiteOpenHelper implements Database {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "fly_dagger_downloader.sqlite";

    /**
     * Singleton to hold the unique instance
     */
    private static DBManager instance;

    /**
     * Database connection management object
     */
    private DBConnectionManagement dbConnection;

    /**
     * Use single instance for this class
     */
    public static DBManager initialize(Context context) {
        if (instance == null) {
            instance = new DBManager(context);
        }
        return instance;
    }

    public static DBManager getInstance() {
        return instance;
    }

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // Object to communicate with physical database file
        DBAccessible dbAccessor = new DBAccessible() {
            @Override
            public SQLiteDatabase open() {
                return DBManager.this.getWritableDatabase();
            }

            @Override
            public void close() {

            }
        };

        // Init connection management
        dbConnection = new DBConnectionManagement(dbAccessor);
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
            for (DAO dao : DAOCreator.getAllDAO(this)) {
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
        Logger.debug("Begin update needed table to retain old data");
        upgradeAllTable(oldVersion);
    }

    public void upgradeAllTable(long oldVersion) {
        SQLiteDatabase db = null;
        try {
            db = dbConnection.open();
            for (DAO dao : DAOCreator.getAllDAO(this)) {
                dao.upgradeTable(oldVersion);
            }
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    private void deleteAllTable() {
        SQLiteDatabase db = null;
        try {
            db = dbConnection.open();
            for (DAO dao : DAOCreator.getAllDAO(this)) {
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
