package co.eipi.java.algo.tree;

public class BinaryTree<T>
{

    public static class Node<U>
    {

	public Node(U data)
	{
	    super();
	    this.data = data;
	}

	public U data;
	public Node<U> left;
	public Node<U> right;

    }

    public Node<T> root;

    public BinaryTree(T rootData)
    {
	this.root = new Node<T>(rootData);
    }
    
    public BinaryTree(Node<T> root)
    {
	this.root = root;
    }

    public Node<T> makeNode(T data)
    {
	return new Node<T>(data);
    }

}
