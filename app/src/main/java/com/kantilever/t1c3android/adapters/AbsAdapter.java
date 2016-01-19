package com.kantilever.t1c3android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Tom on 19-1-2016.
 */
public class AbsAdapter<T> extends BaseAdapter {

    /**
     * The Context.
     */
    protected Context context;
    /**
     * The Data.
     */
    protected T[] data;

    protected static LayoutInflater inflater = null;

    public AbsAdapter(Context context, T[] data){
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
