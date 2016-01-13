package mont.cristo.flydaggerdownloader.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mont.cristo.flydaggerdownloader.R;
import mont.cristo.flydaggerdownloader.helpers.network.DownloadInfo;

public class DownloadListAdapter extends BaseAdapter<DownloadInfo> {

    public DownloadListAdapter(List<DownloadInfo> listDataSource) {
        super(listDataSource);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        final ViewHolder viewHolder;
        if (v == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_download_list, parent, false);
            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }
        final DownloadInfo downloadInfo = listDataSource.get(position);
        DownloadViewFilter downloadViewFilter = new DownloadViewFilter(downloadInfo);
        viewHolder.tvDownloadFileName.setText(downloadViewFilter.getFileName());
        viewHolder.ivDownloadIcon.setImageResource(downloadViewFilter.getIcon());
        return v;
    }

    static class ViewHolder {
        private TextView tvDownloadFileName;
        private TextView tvDownloadStatus;
        private ImageView ivDownloadIcon;

        public ViewHolder(View root) {
            tvDownloadFileName = (TextView) root.findViewById(R.id.tv_download_file_name);
            tvDownloadStatus = (TextView) root.findViewById(R.id.tv_download_status);
            ivDownloadIcon = (ImageView) root.findViewById(R.id.iv_download_icon);
        }
    }
}
