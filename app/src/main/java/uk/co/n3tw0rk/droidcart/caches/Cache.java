package uk.co.n3tw0rk.droidcart.caches;

public abstract class Cache <T> {

    T data;

    protected abstract void init();

    public synchronized T get() {
        if (null == data) {
            init();
        }

        return data;
    }

    public synchronized void set(T cache) {
        data = cache;
    }
}
