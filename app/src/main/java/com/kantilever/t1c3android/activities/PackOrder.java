package com.kantilever.t1c3android.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.adapters.OrderAdapter;
import com.kantilever.t1c3android.models.OrderItem;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class PackOrder extends AppCompatActivity {

    List<Integer> testArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pack_order);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pack_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadData() {
        ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();
        OrderAdapter orderAdapter = new OrderAdapter(this, orderList);
        OrderItem newOrderItem = new OrderItem(1, "DONE");
        orderAdapter.add(newOrderItem);
        ListView listView = (ListView) findViewById(R.id.packOrderList);
        listView.setAdapter(orderAdapter);
    }
}