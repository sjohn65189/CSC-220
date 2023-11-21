/* ***************************************************************************
 * Stephan Johnson
 * 11/4/2022
 * Tree.java
 *
 * <a simple, short program/class description>
 * **************************************************************************/
class Tree
{
    private Node root;
    private int size;
    public static final int MAX_SIZE = 30;

    // Constructor. An empty tree has a size of 0.
    public Tree()
    {
		size = 0;
		root = null;
    }

    // Copy constructor. Clones Tree t (i.e. its nodes, and its size)
    public Tree(Tree t)
    {
		this.size = t.size;
		root = mycopy(t.root);
    }

    // Private copy function that recursively copies Node a (along with
    // all its links, and returns that copy.
    private Node mycopy(Node a)
    {
		if (a == null)
		{
			return null;
		}
		else
		{
			Node newNode = new Node(a.getData());
			newNode.setLeft(mycopy(a.getLeft()));
			newNode.setRight(mycopy(a.getRight()));
			return newNode;
		}
    }

    // function that takes the key and calls the deleteKey function.
    // Should only work if the tree is not empty.
    public void Delete(int key)
    {
		root = this.DeleteKey(root, key);
		size--;
    }

    // private recursive function that takes a node, and the key to delete from
    // the subtrees attached to that node. It returns a copy of the tree
    // with the required node having been removed from the appropriate subtrees.
    private Node DeleteKey(Node a, int key)
    {
		if (a == null)
		{
			size--;
			return a;
		}
		else if (key < a.getData())
		{
			a.setLeft(this.DeleteKey(a.getLeft(), key));
		}
		else if (key > a.getData())
		{
			a.setRight(this.DeleteKey(a.getRight(), key));
		}
		else
		{
			if (a.getLeft() == null && a.getRight() == null)
			{
				return null;
			}
			else if (a.getLeft() == null)
			{
				return a.getRight();
			}
			else if (a.getRight() == null)
			{
				return a.getLeft();
			}
			else
			{	
				int min = getMin();
				a.setData(min);
				a.setRight(this.DeleteKey(a.getRight(), min));
			}
		}
		return a;
    }

    // Private function to find the successor to a node. The successor
    // of a node in a binary tree is the node immediately larger than
    // the required node.
    // // private Node Successor(Node a)
    // // {
    // // }


    // Function to insert data into the tree in its appropriate location
    // by using the Add() recursive function. This should not be
    // possible for a tree that is already full. If the tree is empty,
    // then it does the insertion itself.
    public void Insert(int data)
    {
		if (IsFull())
		{
			
		}
		else
		{
			Add(data, root);
			size++;
		}
    }

    // Private recursive function that takes a Node attached to its own 
    // subtrees, and attaches the data to the tree in the proper location.
    private void Add(int data, Node a)
    {
	    if (a == null)
        {
			a = new Node(data);
			root = a;
			return;
        }
		else if (data < a.getData())
		{
			if (a.getLeft() == null)
			{
				a.setLeft(new Node(data));
			}
			else
			{
				Add(data, a.getLeft());
			}
		}
		else if (data > a.getData())
		{
			if (a.getRight() == null)
			{
				a.setRight(new Node(data));
			}
			else
			{
				Add(data, a.getRight());
			}
		}	
    }

    // function to return the size of the tree (i.e. the number of nodes
    // in the tree).
    public int Size()
    {
		return size;
    }

    // Function to tell whether the tree is empty or not.
    public boolean IsEmpty()
    {
		return (size == 0);
    }

    // Function to tell whether the tree is full or not.
    public boolean IsFull()
    {
		return (size == MAX_SIZE);
    }

    // Function to return the InOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the inorder traversal of the tree.
    private String InOrder(Node a, String s)
    {
		if (a != null)
		{
			s = InOrder(a.getLeft(), s);
			s = s + a.getData() + " ";
			s = InOrder(a.getRight(), s);
		}
		return s;
    }

    // Function to return the PreOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the preorder traversal of the tree.
    private String PreOrder(Node a, String s)
    {
		if (a != null)
		{
			s = s + a.getData() + " ";
			s = PreOrder(a.getLeft(), s);
			s = PreOrder(a.getRight(), s);
		}
		return s;
    }

    // Function to return the PostOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the postorder traversal of the tree.
    private String PostOrder(Node a, String s)
    {
		if (a != null)
		{
			s = PreOrder(a.getLeft(), s);
			s = PreOrder(a.getRight(), s);
			s = s + a.getData() + " ";
		}
		return s;
    }

    // A function that returns the maximum value in the tree. That value
    // is -1 for an empty tree.
    public int getMax()
    {
		Node r = root;
		if (IsEmpty())
		{
			return -1;
		}
		else
		{
			while (r.getRight() != null)
			{
				r = r.getRight();
			}
			return r.getData();
		}	
    }

    // A function that returns the minimum value in the tree. That value
    // is -1 for an empty tree.
    public int getMin()
    {
		Node r = root;
		if (IsEmpty())
		{
			return -1;
		}
		else
		{
			while (r.getLeft() != null)
			{
				r = r.getLeft();
			}
			return r.getData();
		}
    }

    // A toString function that returns "NULL" if the tree is empty.
    // Otherwise, it returns the InOrder traversal of the tree.
    public String toString()
    {
		if (IsEmpty())
		{
			return "NULL";
		}
		else
		{
			String st = " ";
			st = InOrder(root, st);
			return st;
		}
    }

    // A Print function that prints out the InOrder, PreOrder, and
    // PostOrder traversals of the tree (each one preceeded by the word
    // identifying what kind of traversal it is). It also calls the
    // private Print() function which prints out the tree sideways.
    public void Print()
    {
		String str = " ";
		
		System.out.println("InOrder: " + InOrder(root, str)); 
		System.out.println("PreOrder: " + PreOrder(root, str)); 
		System.out.println("PostOrder: " + PostOrder(root, str)); 
		
		Print(root, 0);
    }

    // A Print function that takes a node and an int to recursively print
    // out the tree sideways. The int "lev" determines how far away from
    // the root that particular node will be printed. (Refer to notes for 
    // details of this function).
    private void Print(Node n, int lev)
    {
		if (n != null)
		{
			Print(n.getRight(), lev + 1);
			
			for (int i = 0; i < lev; i++)
			{
				System.out.print("\t");
			}
			System.out.println(n.getData());
			
			Print(n.getLeft(), lev + 1);
		}
    }

    // A function that returns if two trees are equal by value.
    public boolean Equals(Tree t)
    {
		String st1 = " ";
		String st2 = " ";
		st1 = InOrder(root, st1);
		st2 = InOrder(t.root, st2);
		
		String st3 = " ";
		String st4 = " ";
		st3 = PreOrder(root, st3);
		st4 = PreOrder(t.root, st4);
		
		if ((st1.equals(st2)) && (st3.equals(st4)))
		{
			return true;
		}
		else
		{
			return false;
		}	
    }
}
