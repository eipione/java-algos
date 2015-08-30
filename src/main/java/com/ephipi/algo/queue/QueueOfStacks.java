package com.ephipi.algo.queue;

import com.ephipi.algo.stack.IStack;
import com.ephipi.algo.stack.Stack;

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
