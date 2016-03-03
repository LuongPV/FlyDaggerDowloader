package mont.cristo.flydaggerdownloader.database.dao.sqlite;

import java.util.ArrayList;
import java.util.List;

import mont.cristo.flydaggerdownloader.database.manager.sqlite.DBManager;

public class DAOCreator {

    public enum DAOType {

        DOWNLOAD

    }

    public static DAO getDAO(DAOType daoType, DBManager dbManager) {
        DAO dao = null;
        switch (daoType) {
            case DOWNLOAD:
                dao = new DownloadDAO(dbManager);
                break;
        }
        return dao;
    }

    /**
     * Get all DAO
     * @param dbManager Each DAO must have corrective database access
     * @return List all DAO
     */
    public static List<DAO> getAllDAO(DBManager dbManager) {
        List<DAO> listDAO = new ArrayList<>();
        for (DAOType daoType : DAOType.values()) {
            listDAO.add(getDAO(daoType, dbManager));
        }
        return listDAO;
    };

}
