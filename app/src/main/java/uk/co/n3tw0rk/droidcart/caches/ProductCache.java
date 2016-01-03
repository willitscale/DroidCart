package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.shopping.Product;

/**
 * Product Cache Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class ProductCache extends Cache<Product> {

    /** */
    private static final ProductCache instance = new ProductCache();

    /**
     *
     */
    private ProductCache() {}

    /**
     *
     * @return
     */
    public static ProductCache instance() {
        return instance;
    }
}
