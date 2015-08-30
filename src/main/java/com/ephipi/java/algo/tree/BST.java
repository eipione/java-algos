package com.ephipi.java.algo.tree;


public class BST
{

    public static class Node
    {

	public Node(Data data)
	{
	    this.data = data;
	}
	public Node(int key, String value)
	{
	    this.data = new Data(key,value);
	}

	public Data data;
	public Node left;
	public Node right;

    }
    
    public static void inOrder(Node root)
    {
	if (root == null) return;
	inOrder(root.left);
	System.out.println(root.data);
	inOrder(root.right);
    }

    
    public static class Data
    {
	private int key;
	private String value;
	public Data(int key, String value)
	{
	    super();
	    this.key = key;
	    this.value = value;
	}
	
	public String toString()
	{
	    return "("+key+":"+value+")";
	}
	
    }

    public static Data binarySearch(Node root, int key)
    {
	Node node = root;

	while (node != null)
	{
	    if (key < node.data.key)
		node = node.left;
	    else if (key > node.data.key)
		node = node.right;
	    else
		return node.data;

	}

	return null;
    }
    
    public static Node findMin(Node node)
    {
	if (node == null)
	    return null;
	while(node.left != null)
	    node = node.left;
	
	return node;
    }
    
    public static Node put(Node node, int key, String value)
    {
	if (node == null) return new Node(key,value);
	
	if (key < node.data.key)
	    node.left = put(node.left,key,value);
	else if (key > node.data.key)
	    node.right = put(node.right,key,value);
	else 
	    node.data.value = value;
	
	return node;
	
    }
    
    public static Node floor(Node node,int key)
    {
	if (node == null) return null;
	
	if (key < node.data.key)
	{
	    return floor(node.left,key);
	}
	else if (key > node.data.key)
	{
	    Node rightFloor = floor(node.right,key);
	    return rightFloor == null ? node : rightFloor;
	}
	else 
	   return node;
    }
    
    public static Node ciel(Node node,int key)
    {
	if (node == null) return null;
	
	if (key > node.data.key)
	{
	    return ciel(node.right,key);
	}
	else if (key < node.data.key)
	{
	    Node leftCiel = ciel(node.left,key);
	    return leftCiel == null ? node : leftCiel;
	}
	else 
	   return node;
    }
    
  
    
    public static void main(String args[])
    {
	Node root = new Node(50,"Fifty");
	
	root.left = new Node(20,"Twenty");
	root.left.left = new Node(10,"Ten");
	root.left.right = new Node(30,"Thirty");
	root.left.right.right = new Node(40,"Forty");
	
	root.right = new Node(80,"Eighty");
	root.right.left = new Node(60,"Sixty");
	root.right.left.right = new Node(70,"Seventy");
	root.right.right = new Node(90,"Ninety");
	root.right.right.right = new Node(100,"Hundred");
	
	put(root,23,"Twenty Three");
	put(root,65,"Sixty Five");
	
	System.out.println(ciel(root,21).data);
	
	
    }

}
