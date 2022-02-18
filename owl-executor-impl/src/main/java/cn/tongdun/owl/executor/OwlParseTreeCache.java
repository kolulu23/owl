package cn.tongdun.owl.executor;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liutianlu
 * <br/>Created 2022/2/17 11:04 AM
 */
public class OwlParseTreeCache implements OwlExecutionCache<String, ParseTree> {

    private final ConcurrentHashMap<String, ParseTree> cache;

    public OwlParseTreeCache(ConcurrentHashMap<String, ParseTree> cache) {
        this.cache = cache;
    }

    @Override
    public void addItem(String key, ParseTree item) {
        if (key != null && item != null) {
            cache.put(key, item);
        }
    }

    @Override
    public ParseTree getItem(String key) {
        if (key != null) {
            return cache.get(key);
        }
        return null;
    }

    @Override
    public void evict(String key) {
        if (key != null) {
            cache.remove(key);
        }
    }

    @Override
    public void evictAll() {
        cache.clear();
    }

    @Override
    public Collection<String> listCachedKeys() {
        return new ArrayList<>(cache.keySet());
    }
}
