package com.ephipi.threads.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SequenceGen
{

    private int counter = 0;

    /**
     * 
     * @return the next integer
     * If you leave out the synchronized keyword, then duplicates 
     * can be potentially generated
     */
    public synchronized int getNext()
    {
	return counter++;
    }

    public static void main(String args[]) throws InterruptedException
    {
	int N = 100;

	final SequenceGen seqGen = new SequenceGen();

	Runnable runner = new Runnable()
	{

	    @Override
	    public void run()
	    {
		for (int j = 0; j < 10; j++)
		{
		    seqGen.getNext();
		}

	    }

	};

	ExecutorService pool = Executors.newCachedThreadPool();

	for (int i = 0; i < N; i++)
	{
	   pool.submit(runner);
	}
	
	pool.shutdown();
	
	// Counter should be N*10 here, it not our generator has generated duplicates!
	System.out.println(seqGen.counter);

    }

}
