package com.kantilever.t1c3android.activities;

import android.widget.ListView;

import com.kantilever.t1c3android.BuildConfig;
import com.kantilever.t1c3android.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class MainActivityTest {
    @Test
    public void testFailToGetItems() throws Exception {
        //Arrange
        final MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(mainActivity);
        final ListView listView = (ListView) mainActivity.findViewById(R.id.list_orders);
        final int expected = 0;
        //Act
        final int amount = listView.getCount();
        //Assert
        assertEquals(expected, amount);
    }
}
