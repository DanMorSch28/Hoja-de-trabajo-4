/**
Rodrigo Corona 15102
Daniel Morales 15526
Clase de stack de un array list implementando la clse stack 
*/

import java.util.ArrayList;


public class StackArrayList<A>
 implements Stack<A>
{
	protected ArrayList<A> data;

	public StackArrayList()
	{
		data = new ArrayList<A>();
	}

	public void push(A item)
	{
		data.add(item);
	}

	public A pop()
	{
		return data.remove(size()-1);
	}

	public A peek()
	{
		return data.get(size() - 1);
	}
	
	public int size()
	{
		return data.size();
	}
  
	public boolean empty()
	{
		return size() == 0;
	}
}
