
/**
 * Node Class
 *
 * @author Jack Ajizian
 * @version 11/25
 */

public class Node
{
    //string placeholder
    private String word;
    //frequency placeholder
    private int frequency;
    //left/right child placeholder
    private Node leftChild, rightChild;

    //Node constructor, String param
    public Node (String word)
    {
        this.word = word;
        this.frequency = 1;
    }

    //increment frequency method
    public void incFrequency()
    {
        frequency++;
    }
   
    //set frequency method, int param
    public void setFrequency(int frequency)
    {
        this.frequency = frequency;
    }

    //set word method, String param
    public void setWord(String word)
    {
        this.word = word;
    }

    //set left child method, Node param
    public void setLeftChild(Node leftChild)
    {
        this.leftChild = leftChild;
    }

    //set right child method, Node param
    public void setRightChild(Node rightChild)
    {
        this.rightChild = rightChild;
    }
    
    //get method for returning frequency 
    public int getFrequency()
    {
        return frequency;
    }

    //get method for returning word
    public String getWord()
    {
        return word;
    }

    //get method for left child
    public Node getLeftChild()
    {
        return leftChild;
    }

    //get method for right child
    public Node getRightChild()
    {
        return rightChild;
    }
}
