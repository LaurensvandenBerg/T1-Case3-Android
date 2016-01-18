package com.kantilever.t1c3android.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

/**
 * Created by Tom on 18-1-2016.
 */
public abstract class AppDialog extends Dialog {

    public AppDialog(Context context) {
        super(context);
    }

    public AppDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected AppDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    protected void setTextView(int textViewId, String text) {
        TextView textView = (TextView) findViewById(textViewId);
        textView.setText(text);
    }
}
