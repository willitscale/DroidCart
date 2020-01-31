package uk.co.n3tw0rk.droidcart.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Objects;
import java.util.logging.Logger;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import uk.co.n3tw0rk.droidcart.R;
import uk.co.n3tw0rk.droidcart.api.ShopAPI;
import uk.co.n3tw0rk.droidcart.caches.ShopCache;
import uk.co.n3tw0rk.droidcart.config.DroidCartConfig;
import uk.co.n3tw0rk.droidcart.definitions.product.Shop;

public class SplashActivity extends DroidCartActivity implements Callback<Shop> {

    protected final int shopId;

    public SplashActivity() {
        super();
        shopId = DroidCartConfig.getInt(DroidCartConfig.SHOP_ID);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a__splash);
        overridePendingTransition(0, R.anim.hold);
        this.load();
    }

    protected void load() {
        getRetrofit()
                .create(ShopAPI.class)
                .getShop(shopId)
                .enqueue(this);
    }

    protected void loaded() {
        Intent intent = new Intent(this, ShopFrontActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResponse(Response<Shop> response, Retrofit retrofit) {
        ShopCache.instance().set(response.body());
        loaded();
    }

    @Override
    public void onFailure(Throwable t) {
        Log.e(this.getClass().getName(), Objects.requireNonNull(t.getMessage()));
    }
}
