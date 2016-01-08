package uk.co.n3tw0rk.droidcart.caches;

/**
 * Cache Abstraction Layer
 *
 * @author <a href="mailto:james@n3tw0rk.co.uk">James Lockhart</a>
 * @version 0.0.1
 */
public abstract class Cache <T> {

    /** */
    protected T data;

    protected abstract void init();

    /**
     *
     * @return
     */
    public synchronized T get() {
        if (null == data) {
            init();
        }

        return data;
    }

    /**
     *
     * @param cache
     */
    public synchronized void set(T cache) {
        data = cache;
    }
}
