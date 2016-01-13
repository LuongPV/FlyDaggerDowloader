package mont.cristo.flydaggerdownloader.database.dao.base;

import mont.cristo.flydaggerdownloader.database.dbcore.DatabaseManager;

public abstract class BaseDAO implements DAO {

    protected DatabaseManager databaseManager;

    public BaseDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
}
