package cn.tongdun.owl.executor;

import java.util.Collection;

/**
 * Caches important or time-consuming operation during the execution of Owl DSL.
 * However, caching is optional, if you don't need to process the same DSL many times, you
 * can just build parse tree every time before walking or visiting the tree.<br/>
 * Normally a {@link OwlExecutor} implementation should have one or more {@link OwlExecutionCache}.
 * Also, {@link OwlExecutionCache} should be thread-safe.
 *
 * @author liutianlu
 * <br/>Created 2022/2/17 10:53 AM
 */
public interface OwlExecutionCache<K, T> {
    void addItem(K key, T item);

    T getItem(K key);

    void evict(K key);

    void evictAll();

    Collection<K> listCachedKeys();
}
