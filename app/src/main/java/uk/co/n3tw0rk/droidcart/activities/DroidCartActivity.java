package uk.co.n3tw0rk.droidcart.activities;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import retrofit.Retrofit;
import uk.co.n3tw0rk.droidcart.application.DroidCart;

/**
 * Droid Cart Activity Abstraction
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
abstract public class DroidCartActivity extends AppCompatActivity {

    /**
     * @return
     */
    public Retrofit getRetrofit() {
        return ((DroidCart) getApplication())
                .getRetrofit();
    }

    /**
     * @param title
     */
    public void setActionBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (null == actionBar) {
            return;
        }
        actionBar.setTitle(title);
    }

    /**
     * @param resource
     */
    public void setActionBarTitle(int resource) {
        Resources resources = getResources();
        if (null == resources) {
            return;
        }
        setActionBarTitle(resources.getString(resource));
    }

    /**
     * Source :  http://stackoverflow.com/questions/4946295/android-expand-collapse-animation
     *
     * @param
     * @return void
     */
    public void expand(final View v) {
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    /**
     * Source :  http://stackoverflow.com/questions/4946295/android-expand-collapse-animation
     *
     * @param
     * @return void
     */
    public void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }
}
