package uk.co.n3tw0rk.droidcart.api;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import uk.co.n3tw0rk.droidcart.definitions.product.Category;

public interface CategoryAPI {

    @GET("/categories/{category_id}")
    Call<Category> getCategory(@Path("category_id") int categoryId, @Query("offset") int offset,
                               @Query("limit") int limit, @Query("attributes[]")String ... attrs);
}
