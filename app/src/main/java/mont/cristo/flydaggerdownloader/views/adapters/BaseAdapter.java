package mont.cristo.flydaggerdownloader.views.adapters;

import java.util.List;

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    protected List<T> listDataSource;

    public BaseAdapter(List<T> listDataSource) {
        this.listDataSource = listDataSource;
    }

    @Override
    public int getCount() {
        return listDataSource.size();
    }

    @Override
    public T getItem(int position) {
        return listDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
