package co.eipi.java.algo.queue;

import co.eipi.java.algo.stack.IStack;
import co.eipi.java.algo.stack.Stack;

public class QueueOfStacks<T> implements IQueue<T>
{
    private final IStack<T> mainStack = new Stack<T>();
    private final IStack<T> reverseStack = new Stack<T>();
    
    @Override
    public void enqueue(T data)
    {
	mainStack.push(data);
    }
    
    private void reorg()
    {
	if (reverseStack.isEmpty())
	{
	    while(!mainStack.isEmpty())
	    {
		reverseStack.push(mainStack.pop());
	    }
	}
    }
    
    @Override
    public T dequeue()
    {
	reorg();
	return reverseStack.pop();
    }
    @Override
    public T peek()
    {
	reorg();
	return reverseStack.peek();
    }

    @Override
    public boolean isEmpty()
    {
	return peek() == null;
    }
    
   
}
