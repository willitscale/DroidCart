package uk.co.n3tw0rk.droidcart.fragments;

import android.content.res.Resources;
import android.view.View;

import androidx.fragment.app.Fragment;

import retrofit.Retrofit;
import uk.co.n3tw0rk.droidcart.activities.DroidCartActivity;

/**
 * Droid Cart Fragment Abstraction Layer
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public abstract class DroidCartFragment extends Fragment {

    /**
     *
     * @return
     */
    public Retrofit getRetrofit() {
        DroidCartActivity activity = (DroidCartActivity)getActivity();
        return activity.getRetrofit();
    }

    /**
     *
     * @return
     */
    public DroidCartActivity getDroidCartActivity() {
        return (DroidCartActivity) getActivity();
    }

    /**
     *
     * @param title
     */
    public void setActionBarTitle(String title) {
        DroidCartActivity activity = getDroidCartActivity();
        if (null == activity) {
            return;
        }
        activity.setActionBarTitle(title);
    }

    /**
     *
     * @param resource
     */
    public void setActionBarTitle(int resource) {
        Resources resources = getResources();
        if (null == resources) {
            return;
        }
        setActionBarTitle(resources.getString(resource));
    }

    /**
     *
     * @param v
     */
    public void expand(final View v) {
        getDroidCartActivity().expand(v);
    }

    /**
     *
     * @param v
     */
    public void collapse(final View v) {
        getDroidCartActivity().collapse(v);
    }

    public void toggle(final View v) {
        if (View.GONE == v.getVisibility()) {
            expand(v);
        } else {
            collapse(v);
        }
    }
}
