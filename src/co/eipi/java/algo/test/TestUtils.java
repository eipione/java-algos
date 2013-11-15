package co.eipi.java.algo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUtils
{
    
    /**
     * Create a random integer list of size = size and values 
     * from 0(inclusive) to max(exclusive)
     * @param size
     * @param max
     * @return
     */
    public static List<Integer> genRandomArray(int size,int max)
    {
	// Specify the size since in this case we know it
	List<Integer> retList = new ArrayList<Integer>(size);
	Random random = new Random();
	for (int i=0;i<size;i++)
	{
	    retList.add(random.nextInt(max));
	}
	
	return retList;
    }
}
