
/**
 * BinarySearchTree Class
 *
 * @author Jack Ajizian
 * @version 11/25
 */
public class BinarySearchTree
{
    //BST root placeholder
    private Node root;

    //constructor
    public BinarySearchTree()
    {
        root = null;
    }

    //insert method for adding nodes to tree, String param
    public void insert(String word)
    {
        //add node to root if empty
        if(root == null)
        {
            root = new Node(word);
        }
        //build the tree
        else
        {
            //create current root placeholder
            Node current = root;
            while(current != null)
            {
                //if both are same, increment
                if(current.getWord().equals(word))
                {
                    current.incFrequency();
                    break;
                }
                //build left child and alphabetize
                else if(current.getWord().compareTo(word) > 0)
                {
                    //new node if null
                    if(current.getLeftChild() == null)
                    {
                        current.setLeftChild(new Node(word));
                        break;
                    }
                    //set right child
                    else
                    {
                        current = current.getLeftChild();
                    }
                }
                //build right child
                else
                {
                    //new node if null
                    if(current.getRightChild() == null)
                    {
                        current.setRightChild(new Node(word));
                        break;
                    }
                    //set right child
                    else
                    {
                        current = current.getRightChild();
                    }
                }
            }
        }
    }

    //search method for looking through tree, String param
    public void search(String word)
    {
        //display to user word being searched
        System.out.println("Searching for: " + word);

        //create current root placeholder
        Node current = root;
        while (current != null)
        {
            //break out if words are the same
            if(current.getWord().equals(word))
            {
                break;
            }
            //build left and alphabetize
            else if(current.getWord().compareTo(word) > 0)
            {
                current = current.getLeftChild();
            }
            //build right
            else
            {
                current = current.getRightChild();
            }
        }

        //when no word found
        if(current == null)
        {
            System.out.println(word + " not found");
        }
        //print word and frequency
        else
        {
            System.out.println("Found word: " + word + ",Frequency = " + current.getFrequency());
        }
    }

    //print pre order method
    public void printPreOrder()
    {
        System.out.println("\nRunning PreOrder Traversal");
        System.out.println("Number following word is it's frequency\n");
        printPreOrder(root);
    }

    //printpreoder method with Node param, moves node in from tree
    void printPreOrder(Node subroot)
    {
        if(subroot == null)
        {
            return;
        }
        
        //print subroot and frequency
        System.out.println(subroot.getWord() + " = " + subroot.getFrequency());
        //print left subtree
        printPreOrder(subroot.getLeftChild());
        //print right subtree
        printPreOrder(subroot.getRightChild());
    }

    //print in order method
    public void printInOrder()
    {
        System.out.println("\nRunning InOrder Traversal");
        printInOrder(root);
    }

    //printinorder method with Node param, moves node in from tree
    void printInOrder(Node subroot)
    {
        if(subroot == null)
        {
            return;
        }
        
        //print left subtree
        printInOrder(subroot.getLeftChild());
        //print subroot and frequency
        System.out.println(subroot.getWord() + " = " + subroot.getFrequency());
        //print right subtree
        printInOrder(subroot.getRightChild());
    }

    //print post order method
    public void printPostOrder()
    {
        System.out.println("\nRunning PostOrder Traversal");
        printPostOrder(root);
    }

    //printpostorder method with Node param, moves in node from tree
    void printPostOrder(Node subroot)
    {
        if(subroot == null)
        {
            return;
        }
        
        //print left subtree
        printPostOrder(subroot.getLeftChild());
        //print right subtree
        printPostOrder(subroot.getRightChild());
        //print subroot and frequency
        System.out.println(subroot.getWord() + " = " + subroot.getFrequency());
    }
}
