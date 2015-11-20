package mont.cristo.flydaggerdownloader.database.dao;

import mont.cristo.flydaggerdownloader.database.DatabaseManager;

public abstract class BaseDAO implements DAO {

    protected DatabaseManager databaseManager;

    public BaseDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
}
