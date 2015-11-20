package mont.cristo.flydaggerdownloader.activities;

import mont.cristo.flydaggerdownloader.R;
import mont.cristo.flydaggerdownloader.helpers.logger.Logger;

public class SplashActivity extends BaseActivity {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        Logger.debug("Initialize views");
    }
}
