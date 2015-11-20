package mont.cristo.flydaggerdownloader.database.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DAOCreator {

    public enum DAOType {

        DOWNLOAD

    }

    public static DAO getDAO(DAOType daoType, SQLiteDatabase db) {
        DAO dao = null;
        switch (daoType) {
            case DOWNLOAD:
                dao = new DownloadDAO(db);
                break;
        }
        return dao;
    }

    /**
     * Get all DAO
     * @param db Each DAO must have corrective database access
     * @return List all DAO
     */
    public static List<DAO> getAllDAO(SQLiteDatabase db) {
        List<DAO> listDAO = new ArrayList<>();
        for (DAOType daoType : DAOType.values()) {
            listDAO.add(getDAO(daoType, db));
        }
        return listDAO;
    };

}
