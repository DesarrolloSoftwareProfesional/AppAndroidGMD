package pe.com.gmd.appgetall;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class PrincipalActivityTest {

    @Rule
    public ActivityTestRule<PrincipalActivity> mActivityTestRule = new ActivityTestRule<>(PrincipalActivity.class);

    @Test
    public void principalActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withText("Login"),
                        withParent(allOf(withId(R.id.activity_principal),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withText("Login"),
                        withParent(allOf(withId(R.id.activity_principal),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withText("Login"),
                        withParent(allOf(withId(R.id.activity_principal),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withText("Login"),
                        withParent(allOf(withId(R.id.activity_principal),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton4.perform(click());

    }

}
