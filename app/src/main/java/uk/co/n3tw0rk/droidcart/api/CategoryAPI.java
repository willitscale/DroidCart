package uk.co.n3tw0rk.droidcart.api;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import uk.co.n3tw0rk.droidcart.definitions.product.Category;


/**
 * Category API Interface
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public interface CategoryAPI {

    /**
     *
     * @param categoryId
     * @param offset
     * @param limit
     * @param attrs
     * @return
     */
    @GET("/category/{category_id}")
    Call<Category> getCategory(@Path("category_id") int categoryId, @Query("offset") int offset,
                               @Query("limit") int limit, @Query("attributes[]")String ... attrs);
}
