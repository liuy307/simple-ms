package com.liuyong.simplems.function;

@FunctionalInterface
public interface CacheSelector<T> {
    T select() throws Exception;
}
