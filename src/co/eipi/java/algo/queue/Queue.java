package co.eipi.java.algo.queue;

public class Queue<T> implements IQueue<T>
{

    public static class Node<U>
    {
	public U data;
	public Node<U> next;
    }

    private Node<T> first;
    private Node<T> last;

    public Queue()
    {

    }

    @Override
    public void enqueue(T data)
    {

	Node<T> newNode = new Node<T>();
	newNode.data = data;

	if (first == null)
	{
	    first = newNode;
	    last = newNode;
	}
	else
	{
	    last.next = newNode;
	    last = newNode;
	}

    }

    @Override
    public T dequeue()
    {
	if (first!= null)
	{
	    T retData = first.data;
	    first = first.next;
	    return retData;

	}
	return null;
    }

    @Override
    public T peek()
    {
	return first == null ? null : first.data;
    }
    
    @Override
    public boolean isEmpty()
    {
	return first == null;
    }
    
}
