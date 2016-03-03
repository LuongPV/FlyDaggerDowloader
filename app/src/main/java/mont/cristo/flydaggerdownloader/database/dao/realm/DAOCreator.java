package mont.cristo.flydaggerdownloader.database.dao.realm;

import java.util.ArrayList;
import java.util.List;

import mont.cristo.flydaggerdownloader.database.dao.realm.downloadinfo.DownloadDAO;
import mont.cristo.flydaggerdownloader.database.manager.base.Database;

public class DAOCreator {

    public enum DAOType {

        DOWNLOAD

    }

    public static DAO getDAO(DAOType daoType, Database database) {
        DAO dao = null;
        switch (daoType) {
            case DOWNLOAD:
                dao = new DownloadDAO(database);
                break;
        }
        return dao;
    }

    /**
     * Get all DAO
     * @param database Each DAO must have corrective database access
     * @return List all DAO
     */
    public static List<DAO> getAllDAO(Database database) {
        List<DAO> listDAO = new ArrayList<>();
        for (DAOType daoType : DAOType.values()) {
            listDAO.add(getDAO(daoType, database));
        }
        return listDAO;
    };

}
