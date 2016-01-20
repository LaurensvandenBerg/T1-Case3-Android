package com.kantilever.t1c3android.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.domain.Customer;

/**
 * The type Customer adapter.
 */
public class CustomerAdapter extends AbsAdapter<Customer> {

    /**
     * Instantiates a new Order adapter.
     *
     * @param context the context
     * @param data    the data
     */
    public CustomerAdapter(Context context, Customer[] data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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
