package mont.cristo.flydaggerdownloader.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import mont.cristo.flydaggerdownloader.database.DatabaseManager;
import mont.cristo.flydaggerdownloader.helpers.logger.Logger;
import mont.cristo.flydaggerdownloader.models.DownloadInfo;

public class DownloadDAO extends BaseDAO {
    private static final String TABLE = "download";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_URL_REMOTE = "url_remote";
    private static final String COLUMN_URL_LOCAL = "url_local";
    private static final String COLUMN_STATUS = "status";

    public DownloadDAO(DatabaseManager databaseManager) {
        super(databaseManager);
    }

    @Override
    public void initTable() {
        String sql = "CREATE TABLE " + TABLE + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_URL_REMOTE + " TEXT, "
                + COLUMN_URL_LOCAL + " TEXT, "
                + COLUMN_STATUS + " INTEGER)";
        databaseManager.execSQL(sql);
    }

    @Override
    public void deleteTable() {
        String sql = "DROP TABLE IF EXISTS " + TABLE;
        databaseManager.execSQL(sql);
    }

    @Override
    public void upgradeTable(int version) {

    }

    /**
     * Insert download record by list
     *
     * @param listDownloadInfo List need to add
     * @return Total record inserted successfully
     */
    public int insertDownloadInfoList(List<DownloadInfo> listDownloadInfo) {
        // Result: Total record inserted successfully, not the auto ID
        int result = 0;
        for (DownloadInfo downloadInfo : listDownloadInfo) {
            if (insertDownloadInfo(downloadInfo)) {
                // If insert successfully, increase result count
                result++;
            }
        }
        return result;
    }

    /**
     * Insert download record
     *
     * @param downloadInfo DownloadInfo object need to add
     * @return Is record added successfully
     */
    public boolean insertDownloadInfo(DownloadInfo downloadInfo) {
        long result = -1;
        try {
            SQLiteDatabase db = databaseManager.openConnection();
            ContentValues values = new ContentValues();
            values.put(COLUMN_URL_REMOTE, downloadInfo.getUrlRemote());
            values.put(COLUMN_URL_LOCAL, downloadInfo.getUrlLocal());
            values.put(COLUMN_STATUS, downloadInfo.getStatus().getStatusCode());
            result = db.insert(TABLE, null, values);
        } catch (Exception e) {
            Logger.warn("Cannot insert DownloadInfo: " + downloadInfo, e);
        } finally {
            databaseManager.closeConnection();
        }
        return result > 0;
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        List<DownloadInfo> result = new ArrayList<>();
        Cursor cursor = null;
        try {
            SQLiteDatabase db = databaseManager.openConnection();
            cursor = db.query(TABLE, null, null, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                DownloadInfo item;
                do {
                    item = new DownloadInfo();
                    item.setUrlRemote(cursor.getString(cursor.getColumnIndex(COLUMN_URL_REMOTE)));
                    item.setUrlLocal(cursor.getString(cursor.getColumnIndex(COLUMN_URL_LOCAL)));
                    result.add(item);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Logger.warn("Cannot get all DownloadInfo", e);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            databaseManager.closeConnection();
        }
        return result;
    }


}
