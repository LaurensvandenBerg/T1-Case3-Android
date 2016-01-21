package com.kantilever.t1c3android.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.domain.Customer;

/**
 * The type Customer dialog.
 */
public class CustomerDialog extends AppDialog {
    /**
     * The Customer.
     */
    private Customer customer;

    /**
     * Instantiates a new Customer dialog.
     *
     * @param customer the customer
     * @param context  the context
     */
    public CustomerDialog(final Customer customer, final Context context) {
        super(context);
        this.customer = customer;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.customer_dialog);
        setTextView(R.id.customer_id_dialog, "Customer id: " + customer.getId());
        setTextView(R.id.customer_name_dialog, "Name: " + customer.toString());
        setTextView(R.id.customer_initials_dialog, "Initials: " + customer.getInitials());
        setTextView(R.id.customer_address_dialog, "Address: " + customer.getAddress().toString());
        setTextView(R.id.customer_zipcode_dialog, "Zipcode: " + customer.getAddress().getZipcode());
    }
}
