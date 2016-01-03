package uk.co.n3tw0rk.droidcart.activities;

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

}
