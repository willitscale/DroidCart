package uk.co.n3tw0rk.droidcart.definitions.shopping;

import java.util.List;
import java.util.Map;

import uk.co.n3tw0rk.droidcart.definitions.Definition;

/**
 * Created by M00SEMARKTWO on 02/01/2016.
 */
public class Product extends Definition {
    public String description;
    public String price;
    public String discount;
    public String image;

    public List<ProductImage> images;
    public Map<String,Map<String,String>> dimensions;
}
