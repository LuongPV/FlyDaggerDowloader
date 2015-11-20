package mont.cristo.flydaggerdownloader.database.dao;

import android.database.sqlite.SQLiteDatabase;

public class DownloadDAO extends BaseDAO {
    private static final String TABLE = "download";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_URL_REMOTE = "url_remote";
    private static final String COLUMN_URL_LOCAL = "url_local";
    private static final String COLUMN_STATUS = "status";

    public DownloadDAO(SQLiteDatabase db) {
        super(db);
    }

    @Override
    public void initTable() {
        String sql = "CREATE TABLE " + TABLE + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_URL_REMOTE + " TEXT, "
                + COLUMN_URL_LOCAL + " TEXT, "
                + COLUMN_STATUS + " INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void deleteTable() {
        String sql = "DROP TABLE IF EXISTS " + TABLE;
        db.execSQL(sql);
    }

//    public boolean insertDownloadInfoList(List<DownloadInfo> listDownloadInfo) {
//
//    }


}
