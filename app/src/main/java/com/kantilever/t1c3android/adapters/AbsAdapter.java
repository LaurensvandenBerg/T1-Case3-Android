package com.kantilever.t1c3android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * The type Abs adapter.
 *
 * @param <T> the type parameter
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

    /**
     * The constant inflater.
     */
    protected static LayoutInflater inflater = null;

    /**
     * Instantiates a new Abs adapter.
     *
     * @param context the context
     * @param data    the data
     */
    public AbsAdapter(Context context, T[] data) {
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
