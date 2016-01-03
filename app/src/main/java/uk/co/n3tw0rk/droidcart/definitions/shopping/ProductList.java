package uk.co.n3tw0rk.droidcart.definitions.shopping;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by M00SEMARKTWO on 22/12/2015.
 */
abstract public class ProductList implements Iterable<Product> {

    final public Map<Integer,Product> products = new ConcurrentHashMap<Integer,Product>();

    /**
     *
     * @param product
     * @return
     */
    public ProductList addProduct(Product product) {
        this.products.put(product.id,product);
        return this;
    }

    /**
     *
     * @param product
     * @return
     */
    public ProductList removeProduct(Product product) {
        return removeProduct(product.id);
    }

    /**
     *
     * @param product
     * @return
     */
    public ProductList removeProduct(Integer product) {
        this.products.remove(product);
        return this;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<Product> iterator() {
        return products.values().iterator();
    }

}
