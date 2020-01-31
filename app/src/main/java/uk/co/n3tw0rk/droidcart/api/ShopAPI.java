package uk.co.n3tw0rk.droidcart.api;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import uk.co.n3tw0rk.droidcart.definitions.product.Shop;

public interface ShopAPI {

    @GET("/shops/{shop_id}")
    Call<Shop> getShop(@Path("shop_id") int shopId);
}
