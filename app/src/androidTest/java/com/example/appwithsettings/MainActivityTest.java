package com.example.appwithsettings;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

//@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

//    @Test
//    public  void test_isActivityInView(){
//
//        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
//        onView(withId(R.id.main)).check(matches(isDisplayed()));
//
//    }

    @Test
    public void test_isActivityInView() {
        ActivityScenario mActivity = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.main)).check(matches(isDisplayed()));

        onView(withId(R.id.toolbar)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void test_isFragmentInView() {
        ActivityScenario mActivity = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.textview_first)).check(matches(isDisplayed()));
    }

    @Test
    public void test_isFragmentNav() {
        ActivityScenario mActivity = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.button_first)).perform(click());
        onView(withId(R.id.secondFragment)).check(matches(isDisplayed()));

    }


}