package mont.cristo.flydaggerdownloader.database.manager.base;

import android.content.Context;

import mont.cristo.flydaggerdownloader.database.manager.sqlite.DBManager;

public class DBCreator {

    public enum DatabaseType {
        SQLITE,
        REALM
    }

    public static Database getDatabase(DatabaseType databaseType, Context context) {
        Database database = null;
        switch (databaseType) {
            case SQLITE:
                database = new DBManager(context);
                break;
            case REALM:
                database = new mont.cristo.flydaggerdownloader.database.manager.realm.DBManager(context);
                break;
        }
        return database;
    }

}
