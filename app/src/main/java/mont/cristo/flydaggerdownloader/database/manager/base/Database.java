package mont.cristo.flydaggerdownloader.database.manager.base;

public interface Database {

    void upgradeAllTable(long oldVersion);

}
