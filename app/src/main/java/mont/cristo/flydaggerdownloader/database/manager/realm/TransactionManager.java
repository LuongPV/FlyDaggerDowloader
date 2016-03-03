package mont.cristo.flydaggerdownloader.database.manager.realm;

import io.realm.Realm;

public class TransactionManager {

    public Realm beginTransaction(Realm realm) {
        realm.beginTransaction();
        return realm;
    }

    public void commitTransaction(Realm realm) {
        realm.commitTransaction();
        realm.close();
    }


}
