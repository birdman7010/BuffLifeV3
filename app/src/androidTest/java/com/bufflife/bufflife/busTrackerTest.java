package com.bufflife.bufflife;

/**
 * Created by birdman on 11/7/15.
 */

import android.content.Intent;

import com.bufflife.bufflife.busTracker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)

public class busTrackerTest {
    @Test
    public void clickingbustracker1_shouldStartLoginActivity() {
        busTracker activity = Robolectric.setupActivity(busTracker.class);
        activity.findViewById(R.id.bustracker1).performClick();

        Intent expectedIntent = new Intent(activity, busTracker.class);
        assertThat(shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);
}
