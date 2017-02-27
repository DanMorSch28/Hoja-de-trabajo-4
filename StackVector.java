/**
Rodrigo Corona 15102
Daniel Morales 15526
Clase de stack de un vector implementando la clse stack 
*/

import java.util.Vector;


public class StackVector<A>
 implements Stack<A>
{
	protected Vector<A> arreglo;
	public 		int 	sp; 

	public StackVector()
	{
		arreglo = new Vector<A>();
	}

	public void push(A item)
	{
		arreglo.add(item);
	}

	public A pop()
	{
		return arreglo.remove(size()-1);
	}

	public A peek()
	{
		return arreglo.get(size() - 1);
	}
	
	public int size()
	{
		return arreglo.size();
	}
  
	public boolean empty()
	{
		return size() == 0;
	}
}
