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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.adapters.OrderAdapter;
import com.kantilever.t1c3android.converter.GsonConverter;
import com.kantilever.t1c3android.dialog.OrderDialog;
import com.kantilever.t1c3android.domain.rest.CustomerOrder;
import com.kantilever.t1c3android.rest.services.OrderService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * The type Main activity.
 */
@SuppressWarnings("squid:IndentationCheck")
public class MainActivity extends AbsActivity {

    private ListView orderList;
    private List<CustomerOrder> customerOrders = new ArrayList<>();
    private List<CustomerOrder> filtered = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setGeneralContent(R.layout.activity_main, R.id.toolbar);
        orderList = (ListView) findViewById(R.id.list_orders);
        OrderService.get().getAll().enqueue(getResult());
        activity = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        final MenuItem ordersMenuItem = menu.findItem(R.id.action_orders);
        ordersMenuItem.setVisible(false);
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
                OrderService.get().getAll().enqueue(getResult());
                break;
            case R.id.action_customers:
                Intent intent = new Intent(this, CustomerActivity.class);
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
        CustomerOrder[] orderArray = {};
        orderArray = filtered.toArray(orderArray);
        orderList.setAdapter(new OrderAdapter(this, orderArray));
        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                RelativeLayout rl = (RelativeLayout) view;
                String item = ((TextView) rl.findViewById(R.id.order_item_row)).getText().toString();
                for (CustomerOrder customerOrder : filtered)
                    if (customerOrder.getOrderId().equals(item)) {
                        OrderDialog dialog = new OrderDialog(customerOrder, activity);
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
            filtered = customerOrders;
        else
            for (CustomerOrder customerOrder : customerOrders)
                if (customerOrder.getOrderId().startsWith(query)) {
                    filtered.add(customerOrder);
                }
    }

    @Override
    protected Callback<JsonElement> getResult() {
        return new Callback<JsonElement>() {

            @Override
            public void onResponse(Response<JsonElement> response) {
                JsonElement jsonElement = response.body();
                JsonArray jsonArray = jsonElement.getAsJsonObject().getAsJsonArray("content");
                customerOrders = GsonConverter.convertArray(jsonArray, CustomerOrder.class);
                search("");
                refresh();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("ERROR", t.getMessage());
            }

        };
    }
}
