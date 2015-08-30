package com.ephipi.java.algo.stack;

public class NStacks
{

    private static final int FACTOR = 10;

    private static class Node
    {
	private int data;
	private int next;
    }

    private final int n;
    private int emptyHead;
    private int[] stackHeads;
    private Node[] nodes;

    public NStacks(int n)
    {
	this.n = n;
	this.emptyHead = 0;
	this.stackHeads = new int[n];
	for (int i = 0; i < n; i++)
	{
	    stackHeads[i] = -1;
	}
	nodes = new Node[n * FACTOR];
	for (int i = 0; i < n * FACTOR; i++)
	{
	    nodes[i] = new Node();
	    nodes[i].data = -1;
	    nodes[i].next = i + 1;
	}

	nodes[n * FACTOR - 1].next = -1;
    }

    public int peek(int stackNo)
    {
	int stackStart = stackHeads[stackNo];
	if (stackStart == -1)
	    throw new RuntimeException("Stack Empty");

	Node head = nodes[stackStart];

	return head.data;
    }

    public void push(int stackNo, int data)
    {
	if (emptyHead == -1)
	    throw new RuntimeException("Capacity Full!");

	// Get the next empty block
	Node emptyBlock = nodes[emptyHead];

	// Store pointer to next empty node
	int nextEmpty = emptyBlock.next;

	// Claim the empty block, make it the new new head
	emptyBlock.data = data;

	emptyBlock.next = stackHeads[stackNo];

	stackHeads[stackNo] = emptyHead;

	// Move the empty head to next available empty
	this.emptyHead = nextEmpty;

    }

    public int pop(int stackNo)
    {
	int stackHead = stackHeads[stackNo];
	if (stackHead == -1)
	    throw new RuntimeException("Stack Empty");

	// Get the head of the stack to pop from
	Node headNode = nodes[stackHead];

	// Get the data to return and the nextHead
	int nextHead = headNode.next;
	int retData = headNode.data;

	// Free up the head of the stack, make it the head of empty
	headNode.data = -1;
	headNode.next = emptyHead;
	
	// The new head of empty is the freed up element
	this.emptyHead = stackHead;

	// The new head of stack is the next head stored from above
	stackHeads[stackNo] = nextHead;

	return retData;
    }
    
    public static void main(String args[])
    {
	NStacks stacks = new NStacks(10);
	
	stacks.push(5, 10);
	stacks.push(7,11);
	stacks.push(5,12);
	
	System.out.println(stacks.pop(5));
	System.out.println(stacks.pop(7));
	System.out.println(stacks.pop(5));
	
    }

}
