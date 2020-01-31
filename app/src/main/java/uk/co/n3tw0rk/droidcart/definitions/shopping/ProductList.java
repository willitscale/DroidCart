package uk.co.n3tw0rk.droidcart.definitions.shopping;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

abstract public class ProductList implements Iterable<Product> {

    public Map<Integer,Product> products = new ConcurrentHashMap<Integer,Product>();

    public ProductList addProduct(Product product) {
        this.products.put(product.id,product);
        return this;
    }

    public ProductList removeProduct(Product product) {
        return removeProduct(product.id);
    }

    public ProductList removeProduct(Integer product) {
        this.products.remove(product);
        return this;
    }

    @Override
    public Iterator<Product> iterator() {
        return products.values().iterator();
    }

    public int size() {
        return products.size();
    }

    public Product get(Integer key) {
        return products.get(key);
    }

    public Product getIndex(int id) {

        Iterator<Product> products = iterator();

        int idx = 0;

        while(products.hasNext()) {
            Product product = products.next();
            if (id == idx++) {
                return product;
            }
        }

        return null;
    }
}
