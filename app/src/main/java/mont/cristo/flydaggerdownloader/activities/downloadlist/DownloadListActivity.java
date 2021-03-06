package mont.cristo.flydaggerdownloader.activities.downloadlist;

import mont.cristo.flydaggerdownloader.R;
import mont.cristo.flydaggerdownloader.activities.base.BaseActivity;
import mont.cristo.flydaggerdownloader.activities.downloaddetail.DownloadDetailIntentWrapper;
import mont.cristo.flydaggerdownloader.helpers.network.DownloadInfo;

public class DownloadListActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_download_list;
    }

    @Override
    protected void initViews() {
        startActivity(new DownloadDetailIntentWrapper(this, new DownloadInfo()));
    }
}
