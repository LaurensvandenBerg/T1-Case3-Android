package com.kantilever.t1c3android.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.domain.rest.CustomerOrder;

public class OrderAdapter extends AbsAdapter<CustomerOrder> {

    /**
     * Instantiates a new Order adapter.
     *
     * @param context the context
     * @param data    the data
     */
    public OrderAdapter(Context context, CustomerOrder[] data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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
