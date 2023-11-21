/* ***************************************************
 * Stephan Johnson	
 * 10/28/2022
 * Queue.java
 *
 * My queue class
 *************************************************** */

// the Queue class
public class Queue<steph>
{
	private List<steph> list;
	
	// the main constructor
	public Queue()
	{
		list = new List<steph>();
	}
	
	// a copy constructor
	public Queue(Queue<steph> q)
	{
		list = new List<steph>(q.list);
	}
	
	public void Enqueue(steph data)
	{
		list.Last();
		list.InsertAfter(data);
	}
	
	public steph Dequeue()
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
	
	public boolean Equals(Queue<steph> q)
	{
		return list.Equals(q.list);
	}
	
	public Queue<steph> Add(Queue<steph> q)
	{
		Queue<steph> combine = new Queue<steph>();
		combine.list = this.list.Add(q.list);
		return combine;
	}
	
	public String toString()
	{
		return list.toString();
	}
}