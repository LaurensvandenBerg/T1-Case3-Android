package com.kantilever.t1c3android.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.converter.GsonConverter;
import com.kantilever.t1c3android.domain.Customer;
import com.kantilever.t1c3android.rest.HateoasCallback;
import com.kantilever.t1c3android.rest.services.CustomerService;

import java.util.List;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    private static HateoasCallback callback = new HateoasCallback();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CustomerService.get().getAll(callback);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback == null)
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                else {
                    // getting the object
                    JsonObject json = callback.getResult();
                    JsonArray jsonArray = json.getAsJsonArray("content");
                    JsonObject customerHateoasJson = jsonArray.get(0).getAsJsonObject();
                    //converters
                    List<Customer> customerList = GsonConverter.convertArray(jsonArray, Customer.class);
                    Customer customer = GsonConverter.convert(customerHateoasJson, Customer.class);
                    Snackbar.make(view, customerList.get(0).getFirstName(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
