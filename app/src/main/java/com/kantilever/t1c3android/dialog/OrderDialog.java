package com.kantilever.t1c3android.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.activities.MainActivity;
import com.kantilever.t1c3android.domain.OrderState;
import com.kantilever.t1c3android.domain.rest.CustomerOrder;
import com.kantilever.t1c3android.rest.services.OrderService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * The type Order dialog.
 */
public class OrderDialog extends Dialog {

    /**
     * The Order id text view.
     */
    TextView orderIdTextView;
    /**
     * The Order status text view.
     */
    TextView orderStatusTextView;
    /**
     * The Shipping.
     */
    Button shipping;
    /**
     * The Giftingpackage.
     */
    Button giftingpackage;
    /**
     * The Customer order.
     */
    CustomerOrder customerOrder;
    /**
     * The Activity.
     */
    MainActivity activity;

    /**
     * Instantiates a new Order dialog.
     *
     * @param customerOrder the customer order
     * @param activity      the activity
     */
    public OrderDialog(final CustomerOrder customerOrder, final MainActivity activity) {
        super(activity);
        this.customerOrder = customerOrder;
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.order_item_dialog);
        orderIdTextView = (TextView) findViewById(R.id.order_id_dialog);
        orderStatusTextView = (TextView) findViewById(R.id.order_status_dialog);
        orderIdTextView.setText("Orderid: " + customerOrder.getOrderId());
        orderStatusTextView.setText("Orderstatus: " + customerOrder.getOrderStatus());
        shipping = (Button) findViewById(R.id.shipping);
        giftingpackage = (Button) findViewById(R.id.giftingpackage);
        setButtons();
    }

    private void setButtons() {
        OrderState state = OrderState.findOrderState(customerOrder.getOrderStatus());
        switch(state) {
            case RUNNING:
                giftingpackage.setOnClickListener(getOnClickListener(OrderState.PACKAGED));
                shipping.setVisibility(View.GONE);
                break;
            case PACKAGED:
                shipping.setOnClickListener(getOnClickListener(OrderState.SHIPPED));
                giftingpackage.setVisibility(View.GONE);
                break;
            default:
                shipping.setVisibility(View.GONE);
                giftingpackage.setVisibility(View.GONE);
                break;
        }
    }

    private void update() {
        activity.refresh();
        OrderService.get().update(customerOrder.getId(), customerOrder, getResult());
        dismiss();
    }

    private View.OnClickListener getOnClickListener(final OrderState orderState) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerOrder.setOrderStatus(orderState.toString());
                update();
            }
        };
    }

    private Callback<JsonElement> getResult() {
        return new Callback<JsonElement>() {
            @Override
            public void success(JsonElement jsonElement, Response response) {
                Log.i("SUCCESS", "JEEJ");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("ERROR", error.getMessage());
            }
        };
    }
}
