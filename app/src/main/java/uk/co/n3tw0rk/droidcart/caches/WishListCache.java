package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.shopping.WishList;

public class WishListCache extends Cache<WishList> {

    private static final WishListCache instance = new WishListCache();

    private WishListCache() {}

    public static WishListCache instance() {
        return instance;
    }

    protected void init() {
        if (null == data) {
            data = new WishList();
        }
    }
}
