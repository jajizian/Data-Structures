
/**
 * PriorityQueue class
 * 
 * @author Jack Ajizian
 * @version 10/25/2018
 * 
 */

public class PriorityQ
{
    //heap creation
    private PriorityCustomer[] custQ;
    //current number of customers in line
    private int size;

    //constructor
    public PriorityQ()
    {
        custQ = new PriorityCustomer[60];
        size = 0;
    }

    //add method
    public void add(PriorityCustomer cust)
    {
        //tracks where object is 
        int index = size + 1;
        //set heap to cust param
        custQ[index] = cust;

        //comparing objects
        while(index > 1)
        {
            //get parent index
            int parent = index / 2;

            //compare objects 
            if(custQ[parent].getPriority() < cust.getPriority())
            {
                //swap objects
                custQ[index] = custQ[parent];
                custQ[parent] = cust;
                index = parent;
            }
            //break if no swap needed
            else
            {
                break;
            }
        }
        //increase size
        size++;
    }

    //remove method 
    public PriorityCustomer remove()
    {
        //temporary root object
        PriorityCustomer temp = custQ[1];
        //temp last object holder
        PriorityCustomer last = custQ[size];
        //set object to last position in root
        custQ[1] = last;
        custQ[size] = null;

        //store index of object moved to root
        int index = 1;

        //compre index to its children
        while(index < size / 2)
        {
            //storing children and indices
            int leftKid = (index * 2) - 1;
            int rightKid = leftKid +1;
            PriorityCustomer leftVal = custQ[leftKid];
            PriorityCustomer rightVal = null;

            //look for right child
            if(rightKid < size)
            {
                rightVal = custQ[rightKid];
            }
            
            //tracking largest child/index
            PriorityCustomer maxKid;
            int maxIndex;

            //comparing left/right children values and setting appropriate values
            if(leftVal.getPriority() >= rightVal.getPriority())
            {
                maxKid = leftVal;
                maxIndex = leftKid;
            }
            else
            {
                maxKid = rightVal;
                maxIndex = rightKid;
            }

            //determine if parent/child swap needed
            if(last.getPriority() < maxKid.getPriority())
            {
                //swap
                custQ[index] = maxKid;
                custQ[maxIndex] = last;
                index = maxIndex;
            }
            //break if no swap needed
            else
            {
                break;
            }
        }
        //decrease size
        size--;
        //return original root
        return temp;
    }

    //front of line tracker
    public PriorityCustomer head()
    {
        return custQ[1];
    }

    //queue size tracker
    public int getSize()
    {
        return size;
    }
}

