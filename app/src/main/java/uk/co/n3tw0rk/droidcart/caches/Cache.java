package uk.co.n3tw0rk.droidcart.caches;

import android.util.SparseArray;

/**
 * Cache Abstraction Layer
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public abstract class Cache <T> {

    /** */
    protected SparseArray<T> data = new SparseArray<T>();

    /**
     *
     * @param id
     * @return
     */
    public synchronized T get(int id) {
        return data.get(id);
    }

    /**
     *
     * @param id
     * @param cache
     */
    public synchronized void set(int id,T cache) {
        data.put(id,cache);
    }

    /**
     *
     * @return
     */
    public synchronized int size() {
        return data.size();
    }
}
