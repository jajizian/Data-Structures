
/**
 * Driver for PriorityQueue
 * 
 * @author Jack Ajizian
 * @version 10/25/2018
 * 
 */

import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
        Random rng = new Random();
        //line counter
        int maxSize = 0;
        //serviced customer counter
        int servedCust = 0;
        //create priority queue
        PriorityQ queue = new PriorityQ();

        System.out.println("Beginning Simulation.");
        //60 minute sim
        for (int x = 1; x <= 60; x++)
        {
            //randomly create customer
            int newCust = rng.nextInt(4) + 1;

            //customer at head of line
            PriorityCustomer head = queue.head();
            
            //if no customer
            if(head == null)
            {
                //set front of line to null
                head = queue.head();
                
                System.out.println("Waiting for next customer.");
            }

            //when new customer is added
            if(newCust == 1)
            {
                //new customer object creation
                PriorityCustomer currentC = new PriorityCustomer();
                //place new customer in queue
                queue.add(currentC);
                System.out.println("New customer added!  Queue length is now " + queue.getSize());
            }

            //when multiple customers in line
            if(head != null)
            {
                //decrease customer service time
                head.decServiceTime();
                
                //when customer is servived
                if(head.getServiceTime() == 0)
                {
                    queue.remove();
                    servedCust++;
                    System.out.println("Customer serviced and removed from queue.  Queue length is now " + queue.getSize());
                    head = null;
                    
                    if(queue.getSize() > 0)
                    {
                        head = queue.head();
                        System.out.println("Servicing next customer.");
                    }
                }
                
            }
            
            //tracking and updating queue size
            if(maxSize == 0)
            {
                maxSize = queue.getSize();
            }

            else if(maxSize < queue.getSize())
            {
                maxSize = queue.getSize();
            }

            System.out.println("---------------------------------------------------------------------");
        }

        //data
        System.out.println("Total number of customers serviced: " + servedCust);
        System.out.println("\nMaximum line size during sim: " + maxSize);
    }
}
