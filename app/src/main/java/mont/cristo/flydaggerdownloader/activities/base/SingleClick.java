package mont.cristo.flydaggerdownloader.activities.base;

import android.view.View;

public interface SingleClick {

    /**
     * Subclass must provide all clickable views need to click single (block all remain clickable views while this clickable view is being clicked)
     * @return All clickable views need to click single
     */
    View[] getClickableViews();

}
