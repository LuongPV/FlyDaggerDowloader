package mont.cristo.flydaggerdownloader.database.dao.realm;

/**
 * This class define all operation that a DAO must have to use database
 */
public interface DAO {

    /**
     * Upgrade this table
     */
    void upgradeTable(long oldVersion);

}
