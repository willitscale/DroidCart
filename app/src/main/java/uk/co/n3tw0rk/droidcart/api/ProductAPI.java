package uk.co.n3tw0rk.droidcart.api;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import uk.co.n3tw0rk.droidcart.definitions.shopping.Product;

/**
 * Product API Interface
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public interface ProductAPI {

    /**
     *
     * @param productId
     * @param attrs
     * @return
     */
    @GET("/product/{product_id}")
    Call<Product> getProduct(@Path("product_id") int productId,
                             @Query("attributes[]")String ... attrs);
}
