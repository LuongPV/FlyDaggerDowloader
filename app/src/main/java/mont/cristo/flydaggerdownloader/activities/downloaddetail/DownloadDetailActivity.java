package mont.cristo.flydaggerdownloader.activities.downloaddetail;

import mont.cristo.flydaggerdownloader.R;
import mont.cristo.flydaggerdownloader.activities.BaseActivity;
import mont.cristo.flydaggerdownloader.helpers.network.DownloadInfo;

public class DownloadDetailActivity extends BaseActivity {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_download_detail;
    }

    @Override
    public void initViews() {
        // Get extra data
        DownloadInfo downloadInfo = new DownloadDetailIntentWrapper(getIntent()).getDownloadInfo();
    }
}
