package mont.cristo.flydaggerdownloader.database.dao;

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

    public void upgrade() {
        upgradeAction.upgrade();
    }

    public interface UpgradeAction {

        void upgrade();

    }
}
