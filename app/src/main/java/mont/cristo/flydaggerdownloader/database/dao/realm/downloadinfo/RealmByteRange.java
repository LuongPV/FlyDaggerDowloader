package mont.cristo.flydaggerdownloader.database.dao.realm.downloadinfo;

import io.realm.RealmObject;

public class RealmByteRange extends RealmObject {
    /**
     * Start index of download will begin
     */
    private int indexStart;

    /**
     * End index of download will end
     */
    private int indexEnd;

    public int getIndexStart() {
        return indexStart;
    }

    public void setIndexStart(int indexStart) {
        this.indexStart = indexStart;
    }

    public int getIndexEnd() {
        return indexEnd;
    }

    public void setIndexEnd(int indexEnd) {
        this.indexEnd = indexEnd;
    }
}
