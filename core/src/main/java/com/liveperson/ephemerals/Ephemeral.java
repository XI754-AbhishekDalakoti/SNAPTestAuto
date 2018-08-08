package com.liveperson.ephemerals;


public interface Ephemeral<T> {

    T get();

    void destroy();

}