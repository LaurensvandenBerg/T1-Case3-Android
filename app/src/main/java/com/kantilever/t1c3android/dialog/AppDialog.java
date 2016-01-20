package com.kantilever.t1c3android.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

/**
 * The type App dialog.
 */
public abstract class AppDialog extends Dialog {

    /**
     * Instantiates a new App dialog.
     *
     * @param context the context
     */
    public AppDialog(Context context) {
        super(context);
    }

    /**
     * Instantiates a new App dialog.
     *
     * @param context    the context
     * @param themeResId the theme res id
     */
    public AppDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    /**
     * Instantiates a new App dialog.
     *
     * @param context        the context
     * @param cancelable     the cancelable
     * @param cancelListener the cancel listener
     */
    protected AppDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    /**
     * Sets text view.
     *
     * @param textViewId the text view id
     * @param text       the text
     */
    protected void setTextView(int textViewId, String text) {
        TextView textView = (TextView) findViewById(textViewId);
        textView.setText(text);
    }
}
