package mont.cristo.flydaggerdownloader.database.dao.sqlite;

import mont.cristo.flydaggerdownloader.database.manager.sqlite.DBManager;

public abstract class BaseDAO implements DAO {

    protected DBManager dbManager;

    private DAOUpgradeInfo[] daoUpgradeInfos;

    public BaseDAO(DBManager dbManager) {
        this.dbManager = dbManager;
        daoUpgradeInfos = getUpgradeInfos();
    }

    @Override
    public void upgradeTable(long oldVersion) {
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
