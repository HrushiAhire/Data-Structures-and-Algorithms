import java.util.*;

class Node
{
    public int data;
    public Node next;

    public Node(int no)
    {
        this.data = no;
        this.next = null;
    }
}

class SinglyLL
{
    public Node first;
    public int iCount;

    //Constructor of SinglyLL class
    public SinglyLL()
    {
        this.first = null;
        this.iCount = 0;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Method which Display elements of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void Display()
    {
        System.out.println("Elements of Linked list are : ");

        Node temp = first;

        while(temp!= null)
        {
            System.out.print("| "+temp.data+" |-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Method which calculates number of elements in Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public int Count()
    {
        return this.iCount;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Method which inserts element at first position of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void InsertFirst(int no)
    {
        Node newn = new Node(no);                     

        if(first == null)
        {
            first = newn;
        }
        else
        {
            newn.next = first;
            first = newn;
        }
        iCount++;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Method which inserts element at last position of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void InsertLast(int no)
    {
        Node newn = new Node(no);                     

        if(first == null)
        {
            first = newn;
        }
        else
        {
            Node temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
        iCount++;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Method which inserts element at specified position in Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void InsertAtPos(int no, int iPos)
    {
        int iSize = Count();

        if((iPos < 1) || (iPos > iSize+1))
        {
            System.out.println("Invalid position");
            return;
        }

        if(iPos == 1)
        {
            InsertFirst(no);
        }
        else if(iPos == iSize+1)
        {
            InsertLast(no);
        }
        else
        {
            Node temp = first;
            for(int iCnt = 1; iCnt < iPos-1; iCnt++)
            {
                temp = temp.next;
            }

            Node newn = new Node(no);
            newn.next = temp.next;
            temp.next = newn;
            iCount++;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Method which deletes element at last position of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void DeleteFirst()
    {
        if(first != null)
        {
            first = first.next;
            iCount--;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Method which deletes last elements of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////
    public void DeleteLast()
    {
        if(first == null)
        {
            return;
        }
        if(first.next == null)
        {
            first = null;
        }
        else
        {
            Node temp = first;

            while(temp.next.next != null)
            {
                temp = temp.next;
            }

            temp.next = null;
        }
        iCount--;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Method which deletes element at specified position in Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void DeleteAtPos(int iPos)
    {
        int iSize = Count();

        if((iPos < 1) || (iPos > iSize))
        {
            System.out.println("Invalid position");
            return;
        }

        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iSize)
        {
            DeleteLast();
        }
        else
        {
            Node temp = first;
            for(int iCnt = 1; iCnt < iPos-1; iCnt++)
            {
                temp = temp.next;
            }

            temp.next = temp.next.next;

            iCount--;
        }        
    }
}

//Main Function
class SinglyLinearLinkedList
{
    public static void main(String arg[])
    {
        SinglyLL obj = new SinglyLL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);

        obj.InsertAtPos(55,4);
        obj.Display();

        System.out.println("Number of elements are : "+obj.Count()); 

        obj.DeleteAtPos(4);

        obj.Display();

        System.out.println("Number of elements are : "+obj.Count()); 

        obj.DeleteFirst();               
        obj.DeleteLast();

        obj.Display();

        System.out.println("Number of elements are : "+obj.Count()); 

    }
}