package uk.co.n3tw0rk.droidcart.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import uk.co.n3tw0rk.droidcart.R;
import uk.co.n3tw0rk.droidcart.api.ProductAPI;
import uk.co.n3tw0rk.droidcart.caches.BasketCache;
import uk.co.n3tw0rk.droidcart.caches.ProductCache;
import uk.co.n3tw0rk.droidcart.caches.WishListCache;
import uk.co.n3tw0rk.droidcart.definitions.shopping.Product;

/**
 * Product Detail Fragment Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class ProductDetailFragment extends DroidCartFragment
        implements Callback<Product>, View.OnClickListener {

    /** */
    public static final String PRODUCT_ID = "__PRODUCT_ID";

    /** */
    protected Product product;

    /** */
    protected int productId;

    /** */
    protected String[] attributes = {
            "dimensions",
            "images"
    };

    /**
     *
     */
    public ProductDetailFragment() {
        super();
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(PRODUCT_ID)) {
            productId = getArguments().getInt(PRODUCT_ID);
            getProduct();
        }
    }

    /**
     *
     */
    public void getProduct() {
        ProductAPI service = getRetrofit()
                .create(ProductAPI.class);
        Call<Product> call = service.getProduct(productId,attributes);
        call.enqueue(this);
    }

    /**
     *
     * @param response
     * @param retrofit
     */
    @Override
    public void onResponse(Response<Product> response, Retrofit retrofit) {
        if (null == product) {
            product = response.body();
            ProductCache.instance().set(productId,product);
        }

        render();
    }

    /**
     *
     */
    public void render() {
        View rootView = getView();

        // Show the product's images
        if (product != null) {
            ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.view_pager_images);
            viewPager.setAdapter(new ImageAdapter(getChildFragmentManager()));

            TextView name = (TextView) rootView.findViewById(R.id.details_name);
            name.setText(product.name);

            TextView price = (TextView) rootView.findViewById(R.id.details_price);
            price.setText(product.price);

            TextView addToWishList = (TextView) rootView.findViewById(R.id.add_to_wish_list);
            addToWishList.setOnClickListener(this);
            addToWishList.setClickable(true);

            TextView addToCart = (TextView) rootView.findViewById(R.id.add_cart);
            addToCart.setOnClickListener(this);
            addToCart.setClickable(true);

            setActionBarTitle(product.name);
        }
    }

    @Override
    public void onClick(View v) {

        String evt = "";

        switch(v.getId()) {
            case R.id.add_cart : {
                BasketCache.instance().get().addProduct(product);
                evt = "Basket";
                break;
            }

            case R.id.add_to_wish_list : {
                WishListCache.instance().get().addProduct(product);
                evt = "Wish List";
                break;
            }
        }

        Toast.makeText(v.getContext(), "Added to " + evt, Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * @param t
     */
    @Override
    public void onFailure(Throwable t) {
        // TODO: Have a dance?
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.f__item_detail, container, false);
        return rootView;
    }

    /**
     *
     */
    public class ImageAdapter extends FragmentPagerAdapter
    {
        /**
         *
         * @param fm
         */
        public ImageAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         *
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new ImageViewer();

            Bundle save = new Bundle();
            save.putString(ImageViewer.IMAGE_URL, product.images.get(position).url);
            fragment.setArguments(save);

            return fragment;
        }

        /**
         *
         * @return
         */
        @Override
        public int getCount() {
            if (null == product) {
                return 0;
            }

            return product.images.size();
        }
    }

    /**
     *
     */
    public static class ImageViewer extends Fragment
    {
        /** */
        public final static String IMAGE_URL = "__IMAGE_URL";

        /** */
        protected String url;

        /**
         *
         */
        public ImageViewer() {
            super();
        }

        /**
         *
         * @param savedInstanceState
         */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (null == savedInstanceState) {
                savedInstanceState = getArguments();
            }

            if (null != savedInstanceState) {
                url = savedInstanceState.getString(IMAGE_URL);
            }
        }

        /**
         *
         * @param inflater
         * @param container
         * @param savedInstanceState
         * @return
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.f__view_pager_image, container, false);

            if (null != url) {
                Picasso.with(getContext()).load(url).resize(0,512).into((ImageView)view);
            }

            return view;
        }
    }
}
