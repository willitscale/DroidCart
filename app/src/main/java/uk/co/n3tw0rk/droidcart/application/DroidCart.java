package uk.co.n3tw0rk.droidcart.application;

import android.app.Application;
import android.content.res.Resources;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import uk.co.n3tw0rk.droidcart.config.DroidCartConfig;
import uk.co.n3tw0rk.droidcart.R;


/**
 * Droid Cart Application Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class DroidCart extends Application {

    /** */
    private Retrofit retrofit = null;

    /**
     *
     */
    @Override
    public void onCreate() {
        super.onCreate();
        setConfig();
    }

    /**
     *
     */
    private void setConfig() {
        Resources resources = getResources();

        // Shop Base URL
        DroidCartConfig.set(DroidCartConfig.BASE_URL,
                resources.getString(R.string.droidcart_shop_base));

        // Shop ID
        DroidCartConfig.set(DroidCartConfig.SHOP_ID,
                resources.getInteger(R.integer.droidcart_shop_id));

        // Version ID
        DroidCartConfig.set(DroidCartConfig.VERSION_ID,
                resources.getString(R.string.droidcart_version));
    }

    /**
     *
     * @return
     */
    public Retrofit getRetrofit() {
        if (null == retrofit) {
            retrofit = new Retrofit.Builder()
                .baseUrl(DroidCartConfig.getString(DroidCartConfig.BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit;
    }
}
