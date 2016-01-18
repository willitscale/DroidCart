package uk.co.n3tw0rk.droidcart.definitions.shopping;

import java.util.List;
import java.util.Map;

import uk.co.n3tw0rk.droidcart.definitions.Definition;

/**
 * Product Definition Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class Product extends Definition {
    public String description;
    public String price;
    public String discount;
    public String image;

    public List<ProductImage> images;
    public Map<String,Map<String,String>> dimensions;

    /**
     *
     * @return
     */
    public String getImage() {

        if (null != image) {
            return image;
        }

        if (null != images && 0 < images.size()) {
            return images.get(0).url;
        }

        return null;
    }
}
