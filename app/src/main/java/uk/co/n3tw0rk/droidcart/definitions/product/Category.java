package uk.co.n3tw0rk.droidcart.definitions.product;

import java.util.List;

import uk.co.n3tw0rk.droidcart.definitions.Definition;
import uk.co.n3tw0rk.droidcart.definitions.shopping.Product;

/**
 * Category Definition Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class Category extends Definition {

    /** */
    public List<Product> products;

    /** */
    public int productCount;

    /**
     *
     * @param category
     */
    public void append(Category category) {
        for (Product product:category.products) {
            products.add(product);
        }
    }
}
