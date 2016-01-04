package uk.co.n3tw0rk.droidcart.activities;

import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

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
     *
     * @return
     */
    public Retrofit getRetrofit() {
        return ((DroidCart)getApplication())
                .getRetrofit();
    }

    /**
     *
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
     *
     * @param resource
     */
    public void setActionBarTitle(int resource) {
        Resources resources = getResources();
        if (null == resources) {
            return;
        }
        setActionBarTitle(resources.getString(resource));
    }

}
