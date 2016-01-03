package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.product.Shop;

/**
 * Shop Cache Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class ShopCache extends Cache<Shop> {

    /** */
    private static final ShopCache instance = new ShopCache();

    /**
     *
     */
    private ShopCache() {}

    /**
     *
     * @return
     */
    public static ShopCache instance() {
        return instance;
    }
}
