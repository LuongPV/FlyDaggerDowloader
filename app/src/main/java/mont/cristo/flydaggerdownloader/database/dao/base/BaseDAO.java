package mont.cristo.flydaggerdownloader.database.dao.base;

import mont.cristo.flydaggerdownloader.database.dao.DAOUpgradeInfo;
import mont.cristo.flydaggerdownloader.database.dbcore.DatabaseManager;

public abstract class BaseDAO implements DAO {

    protected DatabaseManager databaseManager;

    private DAOUpgradeInfo[] daoUpgradeInfos;

    public BaseDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        daoUpgradeInfos = getUpgradeInfos();
    }

    @Override
    public void upgradeTable(int oldVersion) {
        for (DAOUpgradeInfo daoUpgradeInfo : daoUpgradeInfos) {
            if (daoUpgradeInfo.getOldVersion() >= oldVersion) {
                daoUpgradeInfo.upgrade();
            }
        }
    }

    /**
     * Subclass must provide db upgrade info by version
     * @return DB upgrade info by version
     */
    protected abstract DAOUpgradeInfo[] getUpgradeInfos();
}
