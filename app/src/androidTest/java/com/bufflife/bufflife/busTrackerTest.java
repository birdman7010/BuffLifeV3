package com.bufflife.bufflife;

/**
 * @author Jesse Bird on 11/7/15.
 */

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.webkit.WebView;
import android.widget.Button;
public class busTrackerTest extends ActivityUnitTestCase<busTracker> {

    private Intent mStartIntent;
    private WebView mButton;

    public busTrackerTest() {
        super(busTracker.class);
    }

    /**
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // In setUp, you can create any shared test data, or set up mock components to inject
        // into your Activity.  But do not call startActivity() until the actual test methods.
        mStartIntent = new Intent(Intent.ACTION_MAIN);
    }

    /**
     * The name 'test preconditions' is a convention to signal that if this
     * test doesn't pass, the test case was not set up properly and it might
     * explain any and all failures in other tests.  This is not guaranteed
     * to run before other tests, as junit uses reflection to find the tests.
     */
    @MediumTest
    public void testPreconditions() {
        startActivity(mStartIntent, null, null);
        mButton = (WebView) getActivity().findViewById(R.id.bustracker1);

        assertNotNull(getActivity());
        assertNotNull(mButton);
    }

    /**
     * This test demonstrates examining the way that activity calls startActivity() to launch
     * other activities.
     */
    @MediumTest
    public void testSubLaunch() {
        busTracker activity = startActivity(mStartIntent, null, null);
        mButton = (WebView) activity.findViewById(R.id.bustracker1);

        // This test confirms that when you click the button, the activity attempts to open
        // another activity (by calling startActivity) and close itself (by calling finish()).
        mButton.performClick();

        //assertNotNull(getStartedActivityIntent());
       // assertTrue(isFinishCalled());
    }

    /**
     * This test demonstrates ways to exercise the Activity's life cycle.
     */
    @MediumTest
    public void testLifeCycleCreate() {
        busTracker activity = startActivity(mStartIntent, null, null);

        // At this point, onCreate() has been called, but nothing else
        // Complete the startup of the activity
        getInstrumentation().callActivityOnStart(activity);
        getInstrumentation().callActivityOnResume(activity);

        // At this point you could test for various configuration aspects, or you could
        // use a Mock Context to confirm that your activity has made certain calls to the system
        // and set itself up properly.

        getInstrumentation().callActivityOnPause(activity);

        // At this point you could confirm that the activity has paused properly, as if it is
        // no longer the topmost activity on screen.

        getInstrumentation().callActivityOnStop(activity);

        // At this point, you could confirm that the activity has shut itself down appropriately,
        // or you could use a Mock Context to confirm that your activity has released any system
        // resources it should no longer be holding.

        // ActivityUnitTestCase.tearDown(), which is always automatically called, will take care
        // of calling onDestroy().
    }

}
