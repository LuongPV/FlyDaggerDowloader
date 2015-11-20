package mont.cristo.flydaggerdownloader.activities;


import android.os.Handler;

import mont.cristo.flydaggerdownloader.R;
import mont.cristo.flydaggerdownloader.activities.menu.MenuIntentWrapper;

public class SplashActivity extends BaseActivity {
    private static final int TIME_WAIT = 3000;
    private Handler handler;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initViews() {
        handler = new Handler();
    }

    @Override
    protected void onPause() {
        super.onPause();
        beginSplash();
    }

    @Override
    protected void onStop() {
        super.onStop();
        endSplash();
    }

    /**
     * This method to start wait for splash
     */
    private void beginSplash() {
        handler.postDelayed(handlerCallback, TIME_WAIT);
    }

    private void endSplash() {
        handler.removeCallbacks(handlerCallback);
    }

    /**
     * Callback when handle done its delay time
     */
    private Runnable handlerCallback = new Runnable() {
        @Override
        public void run() {
            // Start next activity
            startActivity(new MenuIntentWrapper(SplashActivity.this));
        }
    };
}
