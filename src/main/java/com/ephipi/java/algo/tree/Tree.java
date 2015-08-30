package com.ephipi.java.algo.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T>
{

    public static class Node<U>
    {
	private U data;
	private List<Node<U>> children;

	public void addChildren(@SuppressWarnings("unchecked") U... elements)
	{
	    if (children == null)
		children = new ArrayList<Node<U>>();

	    for (U element : elements)
	    {
		Node<U> newNode = new Node<U>();
		newNode.data = element;
		children.add(newNode);
	    }
	}

	public U getData()
	{
	    return data;
	}

	public List<Node<U>> getChildren()
	{
	    return children;
	}

    }

    private Node<T> root;

    public Tree(T rootData)
    {
	this.root = new Node<T>();
	root.data = rootData;
    }

}
