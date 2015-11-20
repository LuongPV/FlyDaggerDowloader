package mont.cristo.flydaggerdownloader.activities.downloaddetail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import mont.cristo.flydaggerdownloader.activities.intentwrapper.ComponentNameIntentWrapper;
import mont.cristo.flydaggerdownloader.models.DownloadInfo;

public class DownloadDetailIntentWrapper extends ComponentNameIntentWrapper {
    private static final String EXTRA_DOWNLOAD_INFO = "download_info";
    private DownloadInfo downloadInfo;

    public DownloadDetailIntentWrapper(@NonNull Context context, @NonNull DownloadInfo downloadInfo) {
        super(context);
        this.downloadInfo = downloadInfo;
    }

    public DownloadDetailIntentWrapper(Intent intent) {
        super(intent);

        // Get extra data
        downloadInfo = (DownloadInfo) intent.getSerializableExtra(EXTRA_DOWNLOAD_INFO);
    }

    @Override
    public Class<?> getDestClass() {
        return DownloadDetailActivity.class;
    }

    @Override
    public void transport() {
        Intent intent = new Intent(context, getDestClass());
        intent.putExtra(EXTRA_DOWNLOAD_INFO, downloadInfo);
        context.startActivity(intent);
    }

    public DownloadInfo getDownloadInfo() {
        return downloadInfo;
    }
}
