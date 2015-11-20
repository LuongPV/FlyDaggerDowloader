package mont.cristo.flydaggerdownloader.models;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class DownloadInfo implements Serializable {

    /**
     * Url for downloaded file location on internet
     */
    private String urlRemote;

    /**
     * Url for downloaded file location on local
     */
    private String urlLocal;

    /**
     * Byte range for download
     */
    private ByteRange byteRange;

    /**
     * Status of this download
     */
    private DownloadStatus status;

    public DownloadInfo(@NonNull String urlRemote, @NonNull String urlLocal, int indexStart, int indexEnd) {
        this.urlRemote = urlRemote;
        this.urlLocal = urlLocal;
        this.byteRange = new ByteRange(indexStart, indexEnd);

        // Default this download info is not in queue
        status = DownloadStatus.NOT_IN_QUEUE;
    }

    public String getUrlRemote() {
        return urlRemote;
    }

    public String getUrlLocal() {
        return urlLocal;
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
