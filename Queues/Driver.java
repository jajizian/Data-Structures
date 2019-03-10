
/**
 * Driver for store Queue
 *
 * @author Jack Ajizian
 * @version 9/23/2018
 */

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Driver
{
    public static void main (String[] args)
    {
        Random rng = new Random();
        //line counter
        int maxSize = 0;
        
        //create linked Q
        LinkedQueue line = new LinkedQueue();
        
        //customer creation
        Customer newCust = null;
        
        System.out.println("Start of Simulation.");
        
        //Q for 60 minutes
        for (int x=1; x <= 60; x++)
        {
            //randomly creates x number of customers to be serviced
            int custNum = rng.nextInt(4)+1;
            
            //when no customers
            if(newCust == null)
            {
                //set front of line to null
                newCust = line.head();
                
                System.out.println("Waiting for next customer.");
            }
            
            //when 1 customer in line
            if(custNum == 1)
            {
                //add new customer to q 
                line.enqueue(new Customer());
                
                System.out.println("New customer added. \nQueue length is now: " + line.getSize());
                
                //set line size to current size
                if(maxSize < line.getSize())
                {
                    maxSize = line.getSize();
                }
            }
            
            //when multiple customers in line
            if(newCust != null)
            {
                //decrease customer service time
                newCust.decServiceTime();
                
                //when customer is serviced
                if(newCust.getServiceTime() == 0)
                {
                    line.dequeue();
                    
                    System.out.println("Customer serviced and removed from the queue."
                    + "\nQueue length is now: " + line.getSize());
                    
                    newCust = null;
                    
                    if(line.getSize() > 0)
                    {
                        newCust = line.head();
                        
                        System.out.println("Servicing next customer.");
                    }
                }
            }
            System.out.println("----------------------------------------------");
        }

        //data 
        System.out.println("Total number of customers serviced: " + line.getTotalCustomers());
        System.out.println("\nMaximum line size during sim: " + maxSize);
    }
}
