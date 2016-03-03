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

    private Context context;

    public DBManager(Context context) {
        this.context = context;
    }

    public void upgradeAllTable(long oldVersion) {
        for (DAO dao : DAOCreator.getAllDAO(this)) {
            dao.upgradeTable(oldVersion);
        }
    }

    public Realm getRealm() {
        realm = Realm.getInstance(new RealmConfiguration.Builder(context)
                .migration(new RealmMigration() {

                    @Override
                    public void migrate(DynamicRealm realm, final long oldVersion, long newVersion) {
                        upgradeAllTable(oldVersion);
                    }
                })
                .schemaVersion(DATABASE_VERSION)
                .build());
        return realm;
    }
}
