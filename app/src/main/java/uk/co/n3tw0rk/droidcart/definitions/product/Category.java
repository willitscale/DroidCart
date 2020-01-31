package uk.co.n3tw0rk.droidcart.definitions.product;

import java.util.List;

import uk.co.n3tw0rk.droidcart.definitions.Definition;
import uk.co.n3tw0rk.droidcart.definitions.shopping.Product;

public class Category extends Definition {

    public List<Product> products;

    public void append(Category category) {
        products.addAll(category.products);
    }
}
