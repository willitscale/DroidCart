package uk.co.n3tw0rk.droidcart.fragments;

import android.support.v4.app.Fragment;

import retrofit.Retrofit;
import uk.co.n3tw0rk.droidcart.activities.DroidCartActivity;

/**
 * Created by M00SEMARKTWO on 02/01/2016.
 */
public class DroidCartFragment extends Fragment {
    public Retrofit getRetrofit() {
        DroidCartActivity activity = (DroidCartActivity)getActivity();
        return activity.getRetrofit();
    }
}
