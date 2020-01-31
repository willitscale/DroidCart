package uk.co.n3tw0rk.droidcart.caches;

import uk.co.n3tw0rk.droidcart.definitions.shopping.Product;

public class ProductCache extends MultiCache<Product> {

    private static final ProductCache instance = new ProductCache();

    private ProductCache() {}

    public static ProductCache instance() {
        return instance;
    }
}
