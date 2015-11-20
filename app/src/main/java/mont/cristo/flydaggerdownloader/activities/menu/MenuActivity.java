package mont.cristo.flydaggerdownloader.activities.menu;

import android.view.View;
import android.widget.ImageButton;

import mont.cristo.flydaggerdownloader.R;
import mont.cristo.flydaggerdownloader.activities.BaseActivity;
import mont.cristo.flydaggerdownloader.activities.downloadlist.DownloadListIntentWrapper;

public class MenuActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_menu;
    }

    @Override
    protected void initViews() {
        ImageButton btnDownloadList = (ImageButton) findViewById(R.id.btn_download_list);
        btnDownloadList.setOnClickListener(menuClickListener);
    }

    private View.OnClickListener menuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_download_list:
                    // Start download list activity
                    startActivity(new DownloadListIntentWrapper(MenuActivity.this));
                    break;
            }
        }
    };
}
