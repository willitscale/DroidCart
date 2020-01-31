package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.product.Shop;

public class ShopCache extends Cache<Shop> {

    private static final ShopCache instance = new ShopCache();

    private ShopCache() {}

    public static ShopCache instance() {
        return instance;
    }

    protected void init() {
        if (null == data) {
            data = new Shop();
        }
    }
}
