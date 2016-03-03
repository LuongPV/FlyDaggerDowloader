package mont.cristo.flydaggerdownloader.database.dao.realm;

import io.realm.Realm;

public abstract class BaseDAO implements DAO {

    protected Realm realm;

    private DAOUpgradeInfo[] daoUpgradeInfos;

    public BaseDAO(Realm realm) {
        this.realm = realm;
        daoUpgradeInfos = getUpgradeInfos();
    }

    @Override
    public void upgradeTable(long oldVersion) {
        for (DAOUpgradeInfo daoUpgradeInfo : daoUpgradeInfos) {
            if (daoUpgradeInfo.getOldVersion() >= oldVersion) {
                daoUpgradeInfo.upgrade(realm);
            }
        }
    }

    /**
     * Subclass must provide db upgrade info by version
     * @return DB upgrade info by version
     */
    protected abstract DAOUpgradeInfo[] getUpgradeInfos();
}
