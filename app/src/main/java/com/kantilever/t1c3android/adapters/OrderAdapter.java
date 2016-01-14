package com.kantilever.t1c3android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.domain.rest.CustomerOrder;

/**
 * Created by laurensoomen on 13/01/16.
 */
public class OrderAdapter extends BaseAdapter {

    /**
     * The Context.
     */
    Context context;
    /**
     * The Data.
     */
    CustomerOrder[] data;
    private static LayoutInflater inflater = null;

    /**
     * Instantiates a new Order adapter.
     *
     * @param context the context
     * @param data    the data
     */
    public OrderAdapter(Context context, CustomerOrder[] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.order_item, null);
        TextView orderIdTextView = (TextView) vi.findViewById(R.id.order_item_row);
        TextView orderStatusTextView = (TextView) vi.findViewById(R.id.order_item_row_status);
        CustomerOrder order = data[position];
        orderIdTextView.setText(order.getOrderId());
        orderStatusTextView.setText(order.getOrderStatus());
        return vi;
    }
}
