package com.ephipi.java.algo.queue;

public interface IQueue<T>
{

    void enqueue(T data);

    T dequeue();

    T peek();
    
    boolean isEmpty();

}
