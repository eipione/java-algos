package co.eipi.java.algo.stack;

public interface IStack<T>
{

    void push(T data);

    T pop();

    boolean isEmpty();

    T peek();

}