package com.mabo.queue;

public interface Queue<T> {

    boolean full();

    boolean empty();

    boolean add(T num)throws Exception ;

    T remove() throws Exception;

    void show();

    int getSize();


}
