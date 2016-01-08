package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.product.Category;

/**
 * Category Cache Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class CategoryCache extends MultiCache<Category> {

    /** */
    private static final CategoryCache instance = new CategoryCache();

    /**
     *
     */
    private CategoryCache() {}

    /**
     *
     * @return
     */
    public static CategoryCache instance() {
        return instance;
    }
}
