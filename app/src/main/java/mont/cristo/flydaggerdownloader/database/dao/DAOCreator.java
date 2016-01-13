package mont.cristo.flydaggerdownloader.database.dao;

import java.util.ArrayList;
import java.util.List;

import mont.cristo.flydaggerdownloader.database.dao.base.DAO;
import mont.cristo.flydaggerdownloader.database.dbcore.DatabaseManager;
import mont.cristo.flydaggerdownloader.database.dao.DownloadDAO;

public class DAOCreator {

    public enum DAOType {

        DOWNLOAD

    }

    public static DAO getDAO(DAOType daoType, DatabaseManager databaseManager) {
        DAO dao = null;
        switch (daoType) {
            case DOWNLOAD:
                dao = new DownloadDAO(databaseManager);
                break;
        }
        return dao;
    }

    /**
     * Get all DAO
     * @param databaseManager Each DAO must have corrective database access
     * @return List all DAO
     */
    public static List<DAO> getAllDAO(DatabaseManager databaseManager) {
        List<DAO> listDAO = new ArrayList<>();
        for (DAOType daoType : DAOType.values()) {
            listDAO.add(getDAO(daoType, databaseManager));
        }
        return listDAO;
    };

}
