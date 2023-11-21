public class Node<gen>
{
	private gen data;
	private Node link;
	
	public Node()
	{
		data = null;
		link = null;
	}
	
	public gen getData()
	{
		return this.data;
	}
	
	public Node getLink()
	{
		return this.link;
	}
	
	public void setData(gen data)
	{
		this.data = data;
	}
	
	public void setLink(Node link)
	{
		this.link = link;
	}
	
	public String toString()
	{
		return "" + data.toString();
	}
}

class NodeTest
{
	public static void main(String [] args)
	{
		Node<Integer> n = new Node<Integer>();
		n.setData(56);
		System.out.println(n);
		
		Node<Character> o = new Node<Character>();
		o.setData('d');
		System.out.println(o);
	}
}
		