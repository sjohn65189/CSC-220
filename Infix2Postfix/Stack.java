/* ***************************************************
 * Stephan Johnson	
 * 10/28/2022
 * Stack.java
 *
 * My stack class
 *************************************************** */

// the Stack class
public class Stack<steph>
{
	private List<steph> list;

	// the main constructor
	public Stack()
	{
		list = new List<steph>();
	}

	// a copy constructor
	public Stack(Stack<steph> s)
	{
		list = new List<steph>(s.list);
	}
	
	public void Push(steph data)
	{
		list.First();
		list.InsertBefore(data);
	}
	
	public steph Pop()
	{
		list.First();
		steph temp = list.GetValue();
		list.Remove();
		return temp;
	}
	
	public steph Peek()
	{
		list.First();
		return list.GetValue();
	}
	
	public int Size()
	{
		return list.GetSize();
	}
	
	public boolean IsEmpty()
	{
		return list.IsEmpty();
	}
	
	public boolean IsFull()
	{
		return list.IsFull();
	}
	
	public boolean Equals(Stack<steph> s)
	{
		return list.Equals(s.list);
	}
	
	public Stack<steph> Add(Stack<steph> s)
	{
		Stack<steph> combine = new Stack<steph>();
		combine.list = this.list.Add(s.list);
		return combine;
	}
	
	public String toString()
	{
		return list.toString();
	}
}