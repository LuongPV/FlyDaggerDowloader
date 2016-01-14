package mont.cristo.flydaggerdownloader.views.dialogs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import mont.cristo.flydaggerdownloader.R;


public class ConfirmationDialog extends BaseDialog {
    private int titleResId;
    private int messageResId;
    private int tvOkResId;
    private Callback callback;

    public ConfirmationDialog(Context context, int titleResId, int messageResId, int tvOkResId, Callback callback) {
        super(context);
        this.titleResId = titleResId;
        this.messageResId = messageResId;
        this.tvOkResId = tvOkResId;
        this.callback = callback;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_confirmation;
    }

    protected void initView() {
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText(titleResId);
        tvTitle.setVisibility(View.GONE);
        TextView tvMessage = (TextView) findViewById(R.id.tv_message);
        tvMessage.setText(messageResId);
        TextView tvOK = (TextView) findViewById(R.id.tv_ok);
        tvOK.setText(tvOkResId);
        tvOK.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
            if (callback != null) {
                callback.onBtnOKPressed();
            }
        }
    };

    public interface Callback {

        void onBtnOKPressed();

    }
}
