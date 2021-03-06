package mont.cristo.flydaggerdownloader.database.dao.sqlite;

/**
 * This class define all operation that a DAO must have to use database
 */
public interface DAO {

    /**
     * Init table to database
     */
    void initTable();

    /**
     * Delete this table
     */
    void deleteTable();

    /**
     * Upgrade this table
     */
    void upgradeTable(long oldVersion);

}
