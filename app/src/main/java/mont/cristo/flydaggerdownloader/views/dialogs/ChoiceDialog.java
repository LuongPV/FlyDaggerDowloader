package mont.cristo.flydaggerdownloader.views.dialogs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import mont.cristo.flydaggerdownloader.R;

public class ChoiceDialog extends BaseDialog {

    private int titleResId;
    private int messageResId;
    private int tvOkResId;
    private int tvCancelResId;
    private Callback callback;

    public ChoiceDialog(Context context, int titleResId, int messageResId, int tvOkResId, int tvCancelResId, Callback callback) {
        super(context);
        this.titleResId = titleResId;
        this.messageResId = messageResId;
        this.tvOkResId = tvOkResId;
        this.tvCancelResId = tvCancelResId;
        this.callback = callback;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_choice;
    }

    protected void initView() {
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText(titleResId);
        tvTitle.setVisibility(View.VISIBLE);
        TextView tvMessage = (TextView) findViewById(R.id.tv_message);
        tvMessage.setText(messageResId);
        TextView tvOK = (TextView) findViewById(R.id.tv_ok);
        tvOK.setText(tvOkResId);
        tvOK.setOnClickListener(onClickListener);
        TextView tvCancel = (TextView) findViewById(R.id.tv_cancel);
        tvCancel.setText(tvCancelResId);
        tvCancel.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
            if (callback != null) {
                switch (v.getId()) {
                    case R.id.tv_ok:
                        callback.onBtnOKPressed();
                        break;
                    case R.id.tv_cancel:
                        callback.onBtnCancelPressed();
                        break;
                }
            }
        }
    };

    public interface Callback {

        void onBtnOKPressed();

        void onBtnCancelPressed();
    }

}
