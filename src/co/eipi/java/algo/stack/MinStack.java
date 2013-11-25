package co.eipi.java.algo.stack;

public class MinStack<T extends Comparable<T>> implements IStack<T>
{

    private final IStack<T> mainStack = new Stack<T>();
    private final IStack<T> minStack = new Stack<T>();

    @Override
    public void push(T data)
    {
	if (minStack.isEmpty() || minStack.peek().compareTo(data) >= 0)
	{
	    minStack.push(data);
	}
	mainStack.push(data);
    }

    @Override
    public T pop()
    {
	if (mainStack.isEmpty())
	    return null;

	T ret = mainStack.pop();

	if (ret.equals(minStack.peek()))
	{
	    minStack.pop();
	}
	
	return ret;
    }

    @Override
    public boolean isEmpty()
    {
	return mainStack.isEmpty();
    }

    @Override
    public T peek()
    {
	return mainStack.peek();
    }
    
    public T min()
    {
	return minStack.peek();
    }
    
    public String toString()
    {
	return "MainStack: " + mainStack +"\n MinStack: " + minStack;
    }

}
