
/**
 * Queue class
 *
 * @author Jack Ajizian
 * @version 9/23/2018
 */
public class LinkedQueue
{
    //placeholders for first/last customers
    private Customer first;
    private Customer last;
    
    //total customers serviced
    int totalCustomers = 0;
    //current number of customers in line
    int size = 0;
    
    //method setting first/last to null
    public LinkedQueue()
    {
        first = null;
        last = null;
    }
    
    //boolean to check if Q is empty
    //if empty, returns first customer as null
    public boolean isEmpty()
    {
        return first == null;
    }
    
    //in q method
    public void enqueue (Customer c)
    {
        //adds customer c to back of the Q
        
        //if the Q is emtpy, first should reference the new object
        if(isEmpty())
        {
            first = c;
        }
        else
        {
            //if Q is not empty, set next customer to last
            last.setNext(c);
        }
        
        //line and total customers serviced tracker
        totalCustomers++;
        size++;
        
        //confirm last is always referencing the new object
        last = c;
    }
    
    //de-Q method
    public Customer dequeue()
    {
        //removes and returns the first customer in Q
        if (isEmpty())
        {
            System.out.println("The queue is already empty");
            return null;
        }
        
        //store a temp reference to object we want to remove
        Customer temp = first;
        
        //set first to reference current firsts objects next reference
        //which is the current second object in the list
        first = first.getNext();
        
        //if Q is now empty, set last to null
        if(isEmpty())
        {
            last = null;
        }
        
        //line tracker
        size--;
        
        return temp;
    }
    
    //front of line
    public Customer head()
    {
        if(isEmpty())
        {
            return null;
        }
        
        return first;
    }
    
    //getter for total customers serviced
    public int getTotalCustomers()
    {
        return totalCustomers;
    }
    
    //getter for current line size
    public int getSize()
    {
        return size;
    }
    
}
