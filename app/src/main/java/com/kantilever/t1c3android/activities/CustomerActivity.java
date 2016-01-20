package com.kantilever.t1c3android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.adapters.CustomerAdapter;
import com.kantilever.t1c3android.converter.GsonConverter;
import com.kantilever.t1c3android.dialog.CustomerDialog;
import com.kantilever.t1c3android.domain.Customer;
import com.kantilever.t1c3android.rest.services.CustomerService;
import com.kantilever.t1c3android.rest.services.OrderService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * The type Customer activity.
 */
@SuppressWarnings("squid:IndentationCheck")
public class CustomerActivity extends AbsActivity {

    private ListView customerList;
    private List<Customer> customers = new ArrayList<>();
    private List<Customer> filtered = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setGeneralContent(R.layout.activity_customer, R.id.toolbar);
        customerList = (ListView) findViewById(R.id.list_customers);
        CustomerService.get().getAll().enqueue(getResult());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        final MenuItem customersMenuItem = menu.findItem(R.id.action_customers);
        customersMenuItem.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_refresh:
                CustomerService.get().getAll().enqueue(getResult());
                break;
            case R.id.action_orders:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Refresh.
     */
    @Override
    public void refresh() {
        Customer[] customersArray = {};
        customersArray = filtered.toArray(customersArray);
        customerList.setAdapter(new CustomerAdapter(this, customersArray));
        customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                RelativeLayout rl = (RelativeLayout) view;
                String item = ((TextView) rl.findViewById(R.id.customer_item_row)).getText().toString();
                for (Customer customer : filtered)
                    if (customer.getId().equals(item)) {
                        CustomerDialog dialog = new CustomerDialog(customer, view.getContext());
                        show(dialog);
                        break;
                    }
            }
        });
    }

    @Override
    protected void search(String query) {
        filtered = new ArrayList<>();
        if ("".equals(query) || query.isEmpty())
            filtered = customers;
        else
            for (Customer customer : customers) {
             String firstName = customer.getFirstName().toLowerCase();
                String lastName = customer.getLastName().toLowerCase();
                if (firstName.contains(query) || lastName.contains(query)) {
                    filtered.add(customer);
                }
            }
    }

    @SuppressWarnings("squid:S1188")
    @Override
    protected Callback<JsonElement> getResult() {
        return new Callback<JsonElement>() {

            @Override
            public void onResponse(Response<JsonElement> response) {
                JsonObject jsonObject = response.body().getAsJsonObject();
                String jsonVersion = jsonObject.get("jsonversion").getAsString();
                if (OrderService.getJsonVersion().equals(jsonVersion)) {
                    JsonElement jsonElement = response.body();
                    JsonArray jsonArray = jsonElement.getAsJsonObject().getAsJsonArray("content");
                    customers = GsonConverter.convertArray(jsonArray, Customer.class);
                    search("");
                    refresh();
                } else {
                    Toast.makeText(CustomerActivity.this, "Please update your app", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("ERROR", t.getMessage());
            }
        };
    }
}
