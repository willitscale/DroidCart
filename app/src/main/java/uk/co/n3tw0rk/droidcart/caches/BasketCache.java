package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.shopping.Basket;

public class BasketCache extends Cache<Basket> {

    private static final BasketCache instance = new BasketCache();

    private BasketCache() {}

    public static BasketCache instance() {
        return instance;
    }

    protected void init() {
        if (null == data) {
            data = new Basket();
        }
    }
}
