package com.kantilever.t1c3android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.domain.Customer;

/**
 * Created by Tom on 18-1-2016.
 */
public class CustomerAdapter extends BaseAdapter {

    /**
     * The Context.
     */
    Context context;
    /**
     * The Data.
     */
    Customer[] data;
    private static LayoutInflater inflater = null;

    /**
     * Instantiates a new Order adapter.
     *
     * @param context the context
     * @param data    the data
     */
    public CustomerAdapter(Context context, Customer[] data) {
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
            vi = inflater.inflate(R.layout.customer_item, null);
        TextView customerIdTextView = (TextView) vi.findViewById(R.id.customer_item_row);
        TextView customerNameTextView = (TextView) vi.findViewById(R.id.customer_item_row_name);
        Customer customer = data[position];
        customerIdTextView.setText(customer.getId());
        customerNameTextView.setText(customer.getFirstName() + " " + customer.getLastName());
        return vi;
    }
}
