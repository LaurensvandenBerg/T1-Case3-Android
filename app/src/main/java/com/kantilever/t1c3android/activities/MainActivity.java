package com.kantilever.t1c3android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
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

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    private ListView orderList;
    private List<CustomerOrder> customerOrders = new ArrayList<>();
    private List<CustomerOrder> filterd = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        orderList = (ListView) findViewById(R.id.list_orders);
        OrderService.get().getAll(getResult());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_refresh:
                OrderService.get().getAll(getResult());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void refresh(){
        CustomerOrder[] orderArray = {};
        orderArray = filterd.toArray(orderArray);
        orderList.setAdapter(new OrderAdapter(this, orderArray));
        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                RelativeLayout rl = (RelativeLayout) view;
                String item = ((TextView)rl.findViewById(R.id.order_item_row)).getText().toString();
                CustomerOrder openDialog = null;
                for (CustomerOrder customerOrder : filterd)
                    if (customerOrder.getOrderId().equals(item)) {
                        openDialog = customerOrder;
                        break;
                    }
                if (openDialog != null)
                    show(openDialog);
            }
        });
    }

    public void show(final CustomerOrder customerOrder)
    {
        OrderDialog orderDialog = new OrderDialog(customerOrder, this);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(orderDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        orderDialog.show();
        orderDialog.getWindow().setAttributes(lp);
    }

    private Callback<JsonElement> getResult(){
        return new Callback<JsonElement>() {

            @Override
            public void success(JsonElement jsonElement, Response response) {
                JsonArray jsonArray = jsonElement.getAsJsonObject().getAsJsonArray("content");
                customerOrders = GsonConverter.convertArray(jsonArray, CustomerOrder.class);
                filterd = customerOrders;
                refresh();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("ERROR", error.getMessage());
            }
        };
    }
}
