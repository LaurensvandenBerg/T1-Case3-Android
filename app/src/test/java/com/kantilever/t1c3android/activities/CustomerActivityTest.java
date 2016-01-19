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
public class CustomerActivityTest {
    @Test
    public void testFailToGetItems() throws Exception {
        //Arrange
        final CustomerActivity customerActivity = Robolectric.setupActivity(CustomerActivity.class);
        assertNotNull(customerActivity);
        final ListView listView = (ListView) customerActivity.findViewById(R.id.list_customers);
        final int expected = 0;
        //Act
        final int amount = listView.getCount();
        //Assert
        assertEquals(expected, amount);
    }
}
