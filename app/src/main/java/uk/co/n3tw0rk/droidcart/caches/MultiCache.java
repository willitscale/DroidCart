package uk.co.n3tw0rk.droidcart.caches;

import android.util.SparseArray;

public abstract class MultiCache <T> {

    private SparseArray<T> data = new SparseArray<T>();

    public synchronized T get(int id) {
        return data.get(id);
    }

    public synchronized void set(int id,T cache) {
        data.put(id,cache);
    }

    public synchronized int size() {
        return data.size();
    }
}
