package uk.co.n3tw0rk.droidcart.api;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import uk.co.n3tw0rk.droidcart.definitions.shopping.Product;

public interface ProductAPI {

    @GET("/products/{product_id}")
    Call<Product> getProduct(@Path("product_id") int productId,
                             @Query("attributes[]")String ... attrs);
}
