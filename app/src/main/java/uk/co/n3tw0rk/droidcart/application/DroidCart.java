package uk.co.n3tw0rk.droidcart.application;

import android.app.Application;
import android.content.res.Resources;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import uk.co.n3tw0rk.droidcart.config.DroidCartConfig;
import uk.co.n3tw0rk.droidcart.R;

public class DroidCart extends Application {

    private Retrofit retrofit = null;

    @Override
    public void onCreate() {
        super.onCreate();
        setConfig();
    }

    private void setConfig() {
        Resources resources = getResources();

        DroidCartConfig.set(DroidCartConfig.BASE_URL,
                resources.getString(R.string.droidcart_shop_base));

        DroidCartConfig.set(DroidCartConfig.SHOP_ID,
                resources.getInteger(R.integer.droidcart_shop_id));

        DroidCartConfig.set(DroidCartConfig.VERSION_ID,
                resources.getString(R.string.droidcart_version));
    }

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
