package mont.cristo.flydaggerdownloader.database.dao.realm;

import io.realm.Realm;
import mont.cristo.flydaggerdownloader.database.manager.base.Database;
import mont.cristo.flydaggerdownloader.database.manager.base.InvalidDatabaseException;
import mont.cristo.flydaggerdownloader.database.manager.realm.DBManager;
import mont.cristo.flydaggerdownloader.database.manager.realm.TransactionManager;

public abstract class BaseDAO implements DAO {

    protected DBManager dbManager;

    private DAOUpgradeInfo[] daoUpgradeInfos;

    protected TransactionManager transactionManager;

    public BaseDAO(Database database) {
        if (!(database instanceof DBManager)) {
            throw new InvalidDatabaseException("Database invalid, must be Realm");
        }
        this.dbManager = (DBManager) database;
        transactionManager = new TransactionManager();
        daoUpgradeInfos = getUpgradeInfos();
    }

    @Override
    public void upgradeTable(long oldVersion) {
        Realm realm = dbManager.getRealm();
        for (DAOUpgradeInfo daoUpgradeInfo : daoUpgradeInfos) {
            if (daoUpgradeInfo.getOldVersion() >= oldVersion) {
                daoUpgradeInfo.upgrade(realm);
            }
        }
        // After update, must close ream
        realm.close();
    }

    /**
     * Subclass must provide db upgrade info by version
     * @return DB upgrade info by version
     */
    protected abstract DAOUpgradeInfo[] getUpgradeInfos();
}
