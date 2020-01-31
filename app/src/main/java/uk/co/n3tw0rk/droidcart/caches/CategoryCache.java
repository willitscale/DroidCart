package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.product.Category;

public class CategoryCache extends MultiCache<Category> {

    private static final CategoryCache instance = new CategoryCache();

    private CategoryCache() {}

    public static CategoryCache instance() {
        return instance;
    }
}
