package uk.co.n3tw0rk.droidcart.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by M00SEMARKTWO on 31/12/2015.
 */
public class DroidCartConfig {

    /** */
    public final static String BASE_URL = "__BASE_URL";

    /** */
    public final static String SHOP_ID = "__SHOP_ID";

    /** */
    public final static String VERSION_ID = "__VERSION_ID";

    /** */
    private final static DroidCartConfig instance = new DroidCartConfig();

    /** */
    private final Map<String,Object> config = new ConcurrentHashMap<String,Object>();

    /**
     *
     */
    private DroidCartConfig(){}

    /**
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        Object obj = instance.config.get(key);
        return obj.toString();
    }

    /**
     *
     * @param key
     * @return
     */
    public static Integer getInt(String key) {
        Object obj = instance.config.get(key);
        if (null == obj) {
            return new Integer(0);
        }
        return (Integer)obj;
    }

    /**
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        instance.config.put(key,value);
    }
}
