/**
Rodrigo Corona 15102
Daniel Morales 15526
Interfaz Stack
*/

public interface Stack<A> 
{

   public void push(A item);
   
   public A pop();
   
   public A peek();
   
   public boolean empty();
   
   public int size();

}