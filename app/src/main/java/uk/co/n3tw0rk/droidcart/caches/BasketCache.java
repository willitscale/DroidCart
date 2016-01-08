package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.shopping.Basket;

/**
 * Basket Cache Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class BasketCache extends Cache<Basket> {

    /** */
    private static final BasketCache instance = new BasketCache();

    /**
     *
     */
    private BasketCache() {}

    /**
     *
     * @return
     */
    public static BasketCache instance() {
        return instance;
    }

    /**
     *
     */
    protected void init() {
        if (null == data) {
            data = new Basket();
        }
    }
}
