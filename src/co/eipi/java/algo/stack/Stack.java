package co.eipi.java.algo.stack;

public class Stack<T> implements IStack<T>
{

    public static class Node<U>
    {
	public U data;
	public Node<U> next;
    }
    
    private Node<T> top;
    
    public Stack()
    {
	
    }
    
    @Override
    public void push(T data)
    {
	Node<T> newNode = new Node<T>();
	newNode.data = data;
	newNode.next = top;
	top = newNode;
    }
    
    @Override
    public T pop()
    {
	if (top !=null)
	{
	    T retData = top.data;
	    top = top.next;
	    return retData;
	}
	return null;
    }
    
    @Override
    public boolean isEmpty()
    {
	return top == null; 
    }
    
    @Override
    public T peek()
    {
	return top == null ? null : top.data;
    }
}
