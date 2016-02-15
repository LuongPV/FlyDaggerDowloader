package mont.cristo.flydaggerdownloader.activities.downloaddetail;

import android.view.View;

import mont.cristo.flydaggerdownloader.R;
import mont.cristo.flydaggerdownloader.activities.base.BaseSingleClickActivity;
import mont.cristo.flydaggerdownloader.helpers.network.DownloadInfo;

public class DownloadDetailActivity extends BaseSingleClickActivity {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_download_detail;
    }

    @Override
    public void initViews() {
        // Get extra data
        DownloadInfo downloadInfo = new DownloadDetailIntentWrapper(getIntent()).getDownloadInfo();
    }

    @Override
    public View[] getClickableViews() {
        return new View[]{};
    }
}
