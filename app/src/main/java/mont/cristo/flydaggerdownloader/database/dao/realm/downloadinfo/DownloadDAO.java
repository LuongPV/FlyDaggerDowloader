package mont.cristo.flydaggerdownloader.database.dao.realm.downloadinfo;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmFieldType;
import io.realm.RealmResults;
import io.realm.internal.Table;
import mont.cristo.flydaggerdownloader.database.dao.Download;
import mont.cristo.flydaggerdownloader.database.dao.realm.BaseDAO;
import mont.cristo.flydaggerdownloader.database.dao.realm.DAOUpgradeInfo;
import mont.cristo.flydaggerdownloader.database.manager.base.Database;
import mont.cristo.flydaggerdownloader.helpers.network.ByteRange;
import mont.cristo.flydaggerdownloader.helpers.network.DownloadInfo;

public class DownloadDAO extends BaseDAO implements Download {
    // Available since version 2
    private static final String FIELD_LOCATION = "location";
    private static final String FIELD_TYPE = "type";
    // Available since version 3
    private static final String FIELD_PROGRESS = "progress";

    public DownloadDAO(Database database) {
        super(database);
    }

    @Override
    protected DAOUpgradeInfo[] getUpgradeInfos() {
        return new DAOUpgradeInfo[] {
                new DAOUpgradeInfo(1, new DAOUpgradeInfo.UpgradeAction() {

                    @Override
                    public void upgrade(Realm realm) {
                        Table downloadTable = realm.getTable(RealmDownloadInfo.class);
                        downloadTable.addColumn(RealmFieldType.STRING, FIELD_LOCATION);
                        downloadTable.addColumn(RealmFieldType.STRING, FIELD_TYPE);
                    }
                }),
                new DAOUpgradeInfo(2, new DAOUpgradeInfo.UpgradeAction() {

                    @Override
                    public void upgrade(Realm realm) {
                        Table downloadTable = realm.getTable(RealmDownloadInfo.class);
                        downloadTable.addColumn(RealmFieldType.STRING, FIELD_PROGRESS);
                    }
                })
        };
    }

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

    public boolean insertDownloadInfo(DownloadInfo downloadInfo) {
        long result = -1;
        Realm realm = dbManager.getRealm();
        realm.beginTransaction();
        RealmDownloadInfo realmDownloadInfo = realm.createObject(RealmDownloadInfo.class);
        realmDownloadInfo.setUrlLocal(downloadInfo.getUrlLocal());
        realmDownloadInfo.setUrlRemote(downloadInfo.getUrlRemote());
        RealmByteRange realmByteRange = realm.createObject(RealmByteRange.class);
        realmByteRange.setIndexStart(downloadInfo.getByteRange().getIndexStart());
        realmByteRange.setIndexEnd(downloadInfo.getByteRange().getIndexEnd());
        realmDownloadInfo.setRealmByteRange(realmByteRange);
        realm.commitTransaction();
        realm.close();
        return result > 0;
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        List<DownloadInfo> result = new ArrayList<>();
        Realm realm = dbManager.getRealm();
        RealmResults<RealmDownloadInfo> realmDownloadInfos = realm.where(RealmDownloadInfo.class).findAll();
        for (RealmDownloadInfo realmDownloadInfo : realmDownloadInfos) {
            result.add(new DownloadInfo(realmDownloadInfo.getUrlRemote(),
                    realmDownloadInfo.getUrlLocal(),
                    new ByteRange(realmDownloadInfo.getRealmByteRange().getIndexStart(),
                            realmDownloadInfo.getRealmByteRange().getIndexEnd())));
        }
        realm.close();
        return result;
    }


}
