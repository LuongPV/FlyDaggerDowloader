package mont.cristo.flydaggerdownloader.helpers.network;

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

    public DownloadInfo() {

    }

    public DownloadInfo(@NonNull String urlRemote, @NonNull String urlLocal, int indexStart, int indexEnd) {
        this(urlRemote, urlLocal, new ByteRange(indexStart, indexEnd));
    }

    public DownloadInfo(@NonNull String urlRemote, @NonNull String urlLocal) {
        this(urlRemote, urlLocal, null);
    }

    public DownloadInfo(@NonNull String urlRemote, @NonNull String urlLocal, ByteRange byteRange) {
        this.urlRemote = urlRemote;
        this.urlLocal = urlLocal;
        this.byteRange = byteRange;
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

    public void setUrlRemote(String urlRemote) {
        this.urlRemote = urlRemote;
    }

    public void setUrlLocal(String urlLocal) {
        this.urlLocal = urlLocal;
    }

    public void setByteRange(ByteRange byteRange) {
        this.byteRange = byteRange;
    }

    public void setStatus(DownloadStatus status) {
        this.status = status;
    }

    public ByteRange getByteRange() {
        return byteRange;
    }
}
