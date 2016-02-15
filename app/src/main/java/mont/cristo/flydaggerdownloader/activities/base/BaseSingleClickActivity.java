package mont.cristo.flydaggerdownloader.activities.base;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Extend this class if need all clickable views in an activity need synchronize click <br />
 * Block all other clickable views while one clickable view is being clicked <br />
 * Clickable views can be Button, clickable TextView, clickable custom view...
 */
public abstract class BaseSingleClickActivity extends BaseActivity implements SingleClick {
    private View[] clickableViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Listen all clickable view state to make them single click
        clickableViews = getClickableViews();
        for (View clickableView : clickableViews) {
            clickableView.setOnTouchListener(onTouchListener);
        }
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    for (View clickableView : clickableViews) {
                        if (clickableView != v) {
                            // Set all other clickable views not able to click (still able to touch), not current clicked clickableView
                            clickableView.setClickable(false);
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    for (View clickableView : clickableViews) {
                        /**
                         * Because a view can only be set onclick false, not ontouch, on touch still working although cannot click
                         * ACTION_DOWN still working, so need to release all clickableView to ensure all clickable views return to its proper state
                         */
                        clickableView.setClickable(true);
                    }
                    break;
            }
            return false;
        }
    };
}
