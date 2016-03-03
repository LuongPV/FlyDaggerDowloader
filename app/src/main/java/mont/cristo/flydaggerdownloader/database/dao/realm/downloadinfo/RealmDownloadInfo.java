package mont.cristo.flydaggerdownloader.database.dao.realm.downloadinfo;

import io.realm.RealmObject;

public class RealmDownloadInfo extends RealmObject {

    /**
     * Url for downloaded file location on internet
     */
    private String urlRemote;

    /**
     * Url for downloaded file location on local
     */
    private String urlLocal;

    private RealmByteRange realmByteRange;

    public String getUrlRemote() {
        return urlRemote;
    }

    public void setUrlRemote(String urlRemote) {
        this.urlRemote = urlRemote;
    }

    public String getUrlLocal() {
        return urlLocal;
    }

    public void setUrlLocal(String urlLocal) {
        this.urlLocal = urlLocal;
    }

    public RealmByteRange getRealmByteRange() {
        return realmByteRange;
    }

    public void setRealmByteRange(RealmByteRange realmByteRange) {
        this.realmByteRange = realmByteRange;
    }
}
