package com.kantilever.t1c3android;

import android.app.Activity;

import com.kantilever.t1c3android.activities.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class OrderDialogTest {

    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        Activity dialog = Robolectric.setupActivity(MainActivity.class);
    }
}
