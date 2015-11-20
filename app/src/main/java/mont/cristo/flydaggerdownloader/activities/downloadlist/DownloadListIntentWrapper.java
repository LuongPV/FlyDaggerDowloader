package mont.cristo.flydaggerdownloader.activities.downloadlist;

import android.content.Context;

import mont.cristo.flydaggerdownloader.activities.intentwrapper.ComponentNameIntentWrapper;

public class DownloadListIntentWrapper extends ComponentNameIntentWrapper {

    public DownloadListIntentWrapper(Context context) {
        super(context);

    }

    @Override
    public Class<?> getDestClass() {
        return DownloadListActivity.class;
    }

    @Override
    public void transport() {

    }
}
