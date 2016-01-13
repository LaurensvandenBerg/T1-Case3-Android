package com.kantilever.t1c3android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.models.OrderItem;

import java.util.ArrayList;

/**
 * Created by laurensoomen on 13/01/16.
 */
public class OrderAdapter extends ArrayAdapter<OrderItem> {

    public OrderAdapter(Context context, ArrayList<OrderItem> orderItems){

        super(context,0,orderItems);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        OrderItem orderItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.order_item, parent, false);
        }
        // Lookup view for data population
        TextView tvOrderID = (TextView) convertView.findViewById(R.id.tvOrderID);
        Button btDetail = (Button) convertView.findViewById(R.id.btDetail);
        Button btPack = (Button) convertView.findViewById(R.id.btPack);
        // Populate the data into the template view using the data object
        tvOrderID.setText(orderItem.orderID);
        // Return the completed view to render on screen
        return convertView;
    }
}
