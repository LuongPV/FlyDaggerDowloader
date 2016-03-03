package mont.cristo.flydaggerdownloader.database.dao.realm;

import io.realm.Realm;

public class DAOUpgradeInfo {
    private int oldVersion;
    private UpgradeAction upgradeAction;

    public DAOUpgradeInfo(int oldVersion, UpgradeAction upgradeAction) {
        this.oldVersion = oldVersion;
        this.upgradeAction = upgradeAction;
    }

    public int getOldVersion() {
        return oldVersion;
    }

    public void upgrade(Realm realm) {
        upgradeAction.upgrade(realm);
    }

    public interface UpgradeAction {

        void upgrade(Realm realm);

    }
}
