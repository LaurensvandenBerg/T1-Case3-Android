package com.kantilever.t1c3android.activities;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SearchView;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.google.gson.JsonElement;
import com.kantilever.t1c3android.R;
import com.kantilever.t1c3android.dialog.AppDialog;

import retrofit.Callback;

/**
 * Created by Tom on 18-1-2016.
 */
public abstract class AbsActivity extends AppCompatActivity {

    protected AbsActivity activity;

    public void setGeneralContent(int viewId, int toolbarId){
        TypefaceProvider.registerDefaultIconSets();
        setContentView(viewId);
        Toolbar toolbar = (Toolbar) findViewById(toolbarId);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query.toLowerCase());
                refresh();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search(newText.toLowerCase());
                refresh();
                return false;
            }
        });
        searchItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                searchView.onActionViewExpanded();
                return false;
            }
        });
        return true;
    }

    protected void show(AppDialog dialog){
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    public abstract void refresh();

    protected abstract void search(String query);

    protected abstract Callback<JsonElement> getResult();
}
