package com.ephipi.algo.linkedlist;

import com.ephipi.algo.linkedlist.LinkedList.Node;

public class CycleDetect
{

    /**
     * Suppose cycle starts K nodes from the head
     * and, size of cycle = M
     * 
     * 
     * @param head
     * @return The Node at the start of the cycle or Null if no cycle
     */
    public static Node detect(Node head)
    {
	Node hare = head;
	Node tort = head;
	
	
	while(tort != null && hare!= null && hare.next != null)
	{
	    tort = tort.next;
	    hare = hare.next.next;
	    
	    if (tort == hare)
		break;
	    
	}
	
	
	if (tort == null || hare == null) return null;

	/*
	 
	 A this stage, we have, 
	
	 Steps Taken by Tortoise = i
	 Location of Tortoise relative to the start of the loop (i - K) mod M
	
	 Steps Taken by Hare = 2i
	 Location of Hare relative to the start of the loop (2i - K) mod M
		
	 Since they are at the same location, this implies
	 (i-K) mod M = (2i -K) mod M
	 Simplifying, ( (2i-K) - (i-K)) mod M = 0
	 => i Mod M = 0
	 
	 Now, if we look at the tortoise if it takes K more steps from where it is 
	 It will be at the position (i-K+K) mod M = i Mod M relative to the start of the loop.
	 
	 And this, we know from above = 0, or the start of the loop
	 
	 So, to count to K, we move the hare to the head of the list and move one step 
	 at a time, while we let the tortoise continue as it is. 
	 When they meet, we have the start of the loop.
	 
	 */
	
	hare = head;
	
	while(hare != tort)
	{
	    hare = hare.next;
	    tort = tort.next;
	}
	
	return hare;
	
    }
}
