package co.eipi.java.algo.stack;

public class Stack<T>
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
    
    public void push(T data)
    {
	Node<T> newNode = new Node<T>();
	newNode.data = data;
	newNode.next = top;
	top = newNode;
    }
    
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
    
    public boolean isEmpty()
    {
	return top == null; 
    }
    
    public T peek()
    {
	return top == null ? null : top.data;
    }
}
