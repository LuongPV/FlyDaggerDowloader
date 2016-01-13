package mont.cristo.flydaggerdownloader.helpers.network;

public enum DownloadStatus {

    /**
     * Download info isn't be added to queue
     */
    NOT_IN_QUEUE (0),

    /**
     * Download info has been enqueued and wait for download
     */
    WAIT_FOR_DOWNLOAD (1),

    /**
     * Download info is being downloaded
     */
    DOWNLOADING (2),

    /**
     * Download info has been downloaded
     */
    DOWNLOADED (3),

    /**
     * Download info has been download failed
     */
    FAILED (4);

    private int statusCode;

    DownloadStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
