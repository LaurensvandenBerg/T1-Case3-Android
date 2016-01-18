package com.kantilever.t1c3android.dialog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.gson.JsonElement;
import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.activities.AbsActivity;
import com.kantilever.t1c3android.domain.OrderState;
import com.kantilever.t1c3android.domain.rest.CustomerOrder;
import com.kantilever.t1c3android.rest.services.OrderService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * The type Order dialog.
 */
public class OrderDialog extends AppDialog {
    /**
     * The Shipping.
     */
    BootstrapButton shipping;
    /**
     * The Giftingpackage.
     */
    BootstrapButton giftingpackage;
    /**
     * The Customer order.
     */
    CustomerOrder customerOrder;
    /**
     * The Activity.
     */
    AbsActivity activity;

    /**
     * Instantiates a new Order dialog.
     *
     * @param customerOrder the customer order
     * @param activity      the activity
     */
    public OrderDialog(final CustomerOrder customerOrder, final AbsActivity activity) {
        super(activity);
        this.customerOrder = customerOrder;
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.order_item_dialog);
        setTextView(R.id.order_id_dialog, "Orderid: " + customerOrder.getOrderId());
        setTextView(R.id.order_status_dialog, "Orderstatus: " + customerOrder.getOrderStatus());
        shipping = (BootstrapButton) findViewById(R.id.shipping);
        giftingpackage = (BootstrapButton) findViewById(R.id.giftingpackage);
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
