package uk.co.n3tw0rk.droidcart.definitions.product;

import java.util.List;

import uk.co.n3tw0rk.droidcart.definitions.Definition;
import uk.co.n3tw0rk.droidcart.definitions.shopping.Product;

/**
 * Created by M00SEMARKTWO on 22/12/2015.
 */
public class Category extends Definition {
    public List<Product> products;
    public int productCount;

    public void append(Category category) {
        for (Product product:category.products) {
            products.add(product);
        }
    }
}
