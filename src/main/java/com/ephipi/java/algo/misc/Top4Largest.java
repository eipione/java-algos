package com.ephipi.java.algo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Top4Largest
{

    public static List<Integer> top4(List<Integer> inList)
    {

	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	
	for (Integer in : inList)
	{
	    insertIfLarge1(queue, in);
	}
	
	List<Integer> ret = new ArrayList<Integer>();

	while(!queue.isEmpty())
	{
	    ret.add(queue.remove());
	}
	
	return ret;
    }

    public static void insertIfLarge(List<Integer> in, Integer m)
    {

	int i = 0;

	while (i < in.size() && m > in.get(i))
	    i++;

	in.add(i, m);

	if (in.size() > 4)
	{
	    in.remove(0);
	}

    }

    public static void insertIfLarge1(PriorityQueue<Integer> queue, Integer m)
    {

	queue.add(m);
	if (queue.size() > 4)
	    queue.remove();

    }

    public static void main(String args[])
    {
	List<Integer> inList = Arrays.asList(1000, 4, 565, 434, 1, 2, 4545,
		767, 2, -1, -100);
	System.out.println(top4(inList));

    }

}
