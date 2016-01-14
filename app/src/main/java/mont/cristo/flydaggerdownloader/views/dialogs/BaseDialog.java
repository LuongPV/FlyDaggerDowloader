package mont.cristo.flydaggerdownloader.views.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import mont.cristo.flydaggerdownloader.helpers.logger.base.Logger;

public abstract class BaseDialog extends Dialog {

    public BaseDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(getLayoutId());
        setCancelable(false);
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    @Override
    public void show() {
        if (isShowing()) {
            Logger.debug("Badly handle dialog: duplicate dialog");
        } else {
            super.show();
        }
    }

    @Override
    public void dismiss() {
        if (!isShowing()) {
            Logger.debug("Badly handle dialog: dialog is currently not showing to be dismissed");
        } else {
            super.dismiss();
        }
    }

}
