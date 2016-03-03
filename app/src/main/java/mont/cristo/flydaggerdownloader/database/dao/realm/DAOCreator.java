package mont.cristo.flydaggerdownloader.database.dao.realm;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import mont.cristo.flydaggerdownloader.database.dao.realm.downloadinfo.DownloadDAO;

public class DAOCreator {

    public enum DAOType {

        DOWNLOAD

    }

    public static DAO getDAO(DAOType daoType, Realm realm) {
        DAO dao = null;
        switch (daoType) {
            case DOWNLOAD:
                dao = new DownloadDAO(realm);
                break;
        }
        return dao;
    }

    /**
     * Get all DAO
     * @param realm Each DAO must have corrective database access
     * @return List all DAO
     */
    public static List<DAO> getAllDAO(Realm realm) {
        List<DAO> listDAO = new ArrayList<>();
        for (DAOType daoType : DAOType.values()) {
            listDAO.add(getDAO(daoType, realm));
        }
        return listDAO;
    };

}
