package mont.cristo.flydaggerdownloader.activities.menu;

import android.content.Context;
import android.content.Intent;

import mont.cristo.flydaggerdownloader.activities.intentwrapper.ComponentNameIntentWrapper;

public class MenuIntentWrapper extends ComponentNameIntentWrapper {

    public MenuIntentWrapper(Context context) {
        super(context);
    }

    @Override
    public Class<?> getDestClass() {
        return MenuActivity.class;
    }

    @Override
    public void transport() {
        Intent intent = new Intent(context, getDestClass());
        context.startActivity(intent);
    }
}
