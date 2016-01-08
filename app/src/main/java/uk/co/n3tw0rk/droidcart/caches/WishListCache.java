package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.shopping.WishList;

/**
 * Wish List Cache Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class WishListCache extends Cache<WishList> {

    /** */
    private static final WishListCache instance = new WishListCache();

    /**
     *
     */
    private WishListCache() {}

    /**
     *
     * @return
     */
    public static WishListCache instance() {
        return instance;
    }

    /**
     *
     */
    protected void init() {
        if (null == data) {
            data = new WishList();
        }
    }
}
