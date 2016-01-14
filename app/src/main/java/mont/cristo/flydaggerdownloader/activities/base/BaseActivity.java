package mont.cristo.flydaggerdownloader.activities.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mont.cristo.flydaggerdownloader.activities.intentwrapper.IntentWrapper;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initViews();
    }

    /**
     * Each sub-class must provide its layout
     * @return Layout resource id
     */
    protected abstract int getLayoutResId();

    /**
     * Each sub-class can get their view component is this method
     */
    protected abstract void initViews();

    /**
     * Sub-class activity should use this method to start a new activity
     * @param intentWrapper Intent wrapper to execute transport
     */
    protected void startActivity(IntentWrapper intentWrapper) {
        intentWrapper.transport();
    }
}
