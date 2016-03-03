package mont.cristo.flydaggerdownloader.database.manager.realm;


import android.content.Context;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import mont.cristo.flydaggerdownloader.database.dao.realm.DAO;
import mont.cristo.flydaggerdownloader.database.dao.realm.DAOCreator;
import mont.cristo.flydaggerdownloader.database.manager.base.Database;

public class DBManager implements Database {
    // Database Version
    private static final long DATABASE_VERSION = 1;

    private Realm realm;

    public DBManager(Context context) {
        realm = Realm.getInstance(new RealmConfiguration.Builder(context)
                .migration(new RealmMigration() {

                    @Override
                    public void migrate(DynamicRealm realm, final long oldVersion, long newVersion) {
                        upgradeAllTable(oldVersion);
                    }
                })
                .schemaVersion(DATABASE_VERSION)
                .build());
    }

    public void upgradeAllTable(long oldVersion) {
        for (DAO dao : DAOCreator.getAllDAO(realm)) {
            dao.upgradeTable(oldVersion);
        }
    }
}
