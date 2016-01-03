package uk.co.n3tw0rk.droidcart.api;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import uk.co.n3tw0rk.droidcart.definitions.product.Shop;

/**
 * Shop API Interface
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public interface ShopAPI {

    /**
     *
     * @param shopId
     * @return
     */
    @GET("/shop/{shop_id}")
    Call<Shop> getShop(@Path("shop_id") int shopId);
}
