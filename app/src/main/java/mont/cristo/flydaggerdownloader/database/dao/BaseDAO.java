package mont.cristo.flydaggerdownloader.database.dao;

import android.database.sqlite.SQLiteDatabase;

public abstract class BaseDAO implements DAO {

    protected SQLiteDatabase db;

    public BaseDAO(SQLiteDatabase db) {
        this.db = db;
    }
}
