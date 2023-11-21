/* ***************************************************
 * Stephan Johnson	
 * 10/11/2022
 * List.java
 *
 * <a simple, short program/class description>
 *************************************************** */

// the Node class
class Node
{
	private int data;
	private Node link;

	// constructor
	public Node()
	{
		this.data = 0;
		this.link = null;
	}

	// accessor and mutator for the data component
	public int getData()
	{
		return this.data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	// accessor and mutator for the link component
	public Node getLink()
	{
		return this.link;
	}

	public void setLink(Node link)
	{
		this.link = link;
	}
}

// the List class
public class List
{
	public static final int MAX_SIZE = 50;

	private Node head;
	private Node tail;
	private Node curr;
	private int num_items;

	// constructor
	// remember that an empty list has a "size" of 0 and its "position" is at -1
	public List()
	{
		head = null;
		tail = null;
		curr = null;
		num_items = 0;
	
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List l)
	{
		head = null;
		tail = null;
		curr = null;
		num_items = 0;
		
		Node new_head = l.head;
		Node new_curr = l.curr;
		Node new_tail = l.tail;
		int new_numItems = l.num_items;
		
		for (int i = 0; i < new_numItems; i++)
		{
			this.InsertAfter(new_head.getData());
			new_head = new_head.getLink();
		}
	}

	// navigates to the beginning of the list
	public void First()
	{
		curr = head;
	}

	// navigates to the end of the list
	// the end of the list is at the last valid item in the list
	public void Last()
	{
		curr = tail;
	}

	// navigates to the specified element (0-index)
	// this should not be possible for an empty list
	// this should not be possible for invalid positions
	public void SetPos(int pos)
	{
		if (IsEmpty())
		{
			
		}
		
		else if (pos <= num_items - 1)
		{
			curr = head;
			for (int i = 0; i < pos; i++)
			{
				Next();
			}
		}
		
	}

	// navigates to the previous element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Prev()
	{
		if (IsEmpty())
		{
			
		}
		else if (curr == head)
		{
			
		}
		else
		{
			Node temp = head;
			while (temp.getLink() != curr)
			{
				temp = temp.getLink();
			}
			curr = temp;
		}	
	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next()
	{
		if (!IsEmpty() && curr != tail)
		{
			curr = curr.getLink();
		}
	}

	// returns the location of the current element (or -1)
	public int GetPos()
	{
		if (IsEmpty())
		{
			return -1;
		}
		else
		{
			int count = 0;
			Node temp = head;
			while (temp != curr)
			{
				count++;
				temp = temp.getLink();
			}
			return count;	
		}
	}

	// returns the value of the current element (or -1)
	public int GetValue()
	{
		if (curr != null)
		{
			return curr.getData();
		}
		return -1;	
	}

	// returns the size of the list
	// size does not imply capacity
	public int GetSize()
	{
		return num_items;
	}

	// inserts an item before the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertBefore(int data)
	{
		if (IsFull())
		{
			
		}
		
		else if (IsEmpty())
		{
			head = new Node();
			head.setData(data);
			curr = tail = head;
			num_items++;
		}
		else if (curr == head)
		{
			Node temp = new Node();
			temp.setData(data);
			temp.setLink(head);
			head = curr = temp;
			num_items++;
			
		}
		else
		{
			Node temp = new Node();
			temp.setData(data);
			temp.setLink(curr);
			Prev();
			curr.setLink(temp);
			curr = temp;
			num_items++;
		}
			
	}

	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(int data)
	{
		if (IsFull())
		{
			
		}
		else if (IsEmpty())
		{
			Node temp = new Node();
			temp.setData(data);
			head = curr = tail = temp;
			num_items++;
		}
		else if (curr.getLink() == null)
		{
			Node temp = new Node();
			curr.setLink(temp);
			temp.setData(data);
			curr = curr.getLink();
			tail = curr;
			num_items++;
		}
		else
		{
			Node temp = new Node(); 
			temp.setData(data);
			temp.setLink(curr);
			Prev();
			curr.setLink(temp);
			curr = temp;
			num_items++;
		}
	}

	// removes the current element (collapsing the list)
	// this should not be possible for an empty list. If possible,
	// following element becomes new current element.
	public void Remove()
	{
		if (IsEmpty())
		{
			
		}
		else if (curr == head)
		{
			Next();
			head = curr;
			num_items--;
		}
		else if (curr == tail)
		{
			Prev();
			curr.setLink(null);
			tail = curr;
			num_items--;
		}
		else
		{
			Node next = curr.getLink();
			Prev();
			curr.setLink(next);
			curr = curr.getLink();
			num_items--;
		}
	}

	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(int data)
	{
		if (IsEmpty())
		{
			
		}
		else
		{
			curr.setData(data);
		}
	}

	// returns if the list is empty
	public boolean IsEmpty()
	{
		return (num_items == 0);
	}

	// returns if the list is full
	public boolean IsFull()
	{
		return (num_items == MAX_SIZE);
	}

	// returns if two lists are equal (by value)
	public boolean Equals(List l)
	{
		Node new_head = l.head;
		Node new_curr = l.curr;
		Node new_tail = l.tail;
		int new_numItems = l.num_items;
		
		if (num_items == new_numItems)
		{
			return true;
		}
		else if (num_items != new_numItems)
		{
			return false;
		}
		
		Node temp = new_head;
		while (head != null && temp != null)
		{
			if (head == temp)
			{
				return true;
			}
			else if (head != temp)
			{
				return false;
			}
			head = head.getLink();
			temp = temp.getLink();
		}
		return true;
		
	}
	

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l)
	{
		List combine = new List(this);
		
		Node temp = l.head;
		for(int i = 0; i < l.num_items; i++)
		{
			combine.InsertAfter(temp.getData());
			temp = temp.getLink();
		}
		return combine;
		
	}

	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString()
	{
		if (IsEmpty())
		{
			return "NULL";
		}
		else
		{
			Node temp = head;
			String str = "";
			while (temp != null)
			{
				str += temp.getData() + " ";
				temp = temp.getLink();
			}
			return str;
		}				
	}
}