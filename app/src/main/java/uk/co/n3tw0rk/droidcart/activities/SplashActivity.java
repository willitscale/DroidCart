package uk.co.n3tw0rk.droidcart.activities;

import android.content.Intent;
import android.os.Bundle;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import uk.co.n3tw0rk.droidcart.R;
import uk.co.n3tw0rk.droidcart.api.ShopAPI;
import uk.co.n3tw0rk.droidcart.caches.ShopCache;
import uk.co.n3tw0rk.droidcart.config.DroidCartConfig;
import uk.co.n3tw0rk.droidcart.definitions.product.Shop;

/**
 * Splash Activity Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class SplashActivity extends DroidCartActivity implements Callback<Shop> {

    /** */
    protected final int shopId;

    /**
     *
     */
    public SplashActivity() {
        super();
        shopId = DroidCartConfig.getInt(DroidCartConfig.SHOP_ID);
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a__splash);

        // Fudge to prevent the black screen between transitions
        overridePendingTransition(0,R.anim.hold);

        // Go get the Shop front details
        this.load();
    }

    /**
     *
     */
    protected void load() {
        ShopAPI service = getRetrofit()
                .create(ShopAPI.class);
        Call<Shop> call = service.getShop(shopId);
        call.enqueue(this);
    }

    /**
     *
     */
    protected void loaded() {
        Intent intent = new Intent(this, ShopFrontActivity.class);
        startActivity(intent);
    }

    /**
     *
     * @param response
     * @param retrofit
     */
    @Override
    public void onResponse(Response<Shop> response, Retrofit retrofit) {
        ShopCache.instance().set(shopId,response.body());
        loaded();
    }

    /**
     *
     * @param t
     */
    @Override
    public void onFailure(Throwable t) {
    }
}
