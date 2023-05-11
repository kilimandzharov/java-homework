package com.kirillmozharov.model;

public interface Filter<T> {
    boolean apply(T item) throws InstantiationException, IllegalAccessException;
}
