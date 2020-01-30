package uk.co.n3tw0rk.droidcart.activities;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import uk.co.n3tw0rk.droidcart.R;
import uk.co.n3tw0rk.droidcart.caches.BasketCache;
import uk.co.n3tw0rk.droidcart.definitions.shopping.Basket;
import uk.co.n3tw0rk.droidcart.definitions.shopping.Product;
import uk.co.n3tw0rk.droidcart.fragments.ProductDetailFragment;

/**
 * Cart Activity Class
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public class BasketActivity extends DroidCartActivity {

    /** */
    protected GridAdapter adapter = new GridAdapter();

    public Context getActivity() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a__basket);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putInt(ProductDetailFragment.PRODUCT_ID,
                    getIntent().getIntExtra(ProductDetailFragment.PRODUCT_ID, 0));

            setActionBarTitle(R.string.basket);
        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.basket_contents);
        recyclerView.setHasFixedSize(true);

        // The number of Columns
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    public class GridAdapter
            extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.r__basket, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {

            Basket basket = BasketCache.instance().get();

            if (null == basket) {
                return;
            }

            holder.product = basket.getIndex(position);

            holder.mNameView.setText(holder.product.name);
            holder.mPriceView.setText(holder.product.price);

            holder.mSaleView.setText(holder.product.discount);
            holder.mSaleView.setPaintFlags(holder.mSaleView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            Log.e("Image", "" + holder.product.getImage());

            Picasso.with(getActivity()).load(holder.product.getImage()).resize(0,512).into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            Basket basket = BasketCache.instance().get();
            if (null == basket) {
                return 0;
            }

            return basket.products.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            final View mView;
            final TextView mNameView;
            final TextView mPriceView;
            final TextView mSaleView;
            final ImageView mImageView;

            public Product product;

            ViewHolder(View view) {
                super(view);
                mView = view;
                mNameView = (TextView) view.findViewById(R.id.name);
                mPriceView = (TextView) view.findViewById(R.id.price);
                mSaleView = (TextView) view.findViewById(R.id.sale);
                mImageView = (ImageView) view.findViewById(R.id.image_view);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mNameView.getText() + "'";
            }
        }
    }
}
