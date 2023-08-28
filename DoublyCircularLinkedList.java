class Node
{
    public int data;
    public Node Next;
    public Node Prev;

    Node(int No)
    {
        this.data = No;
        this.Next = null;
        this.Prev = null;
    }
}

class DoublyCLL
{
    public Node First;
    public Node Last;
    public int iCount;

    DoublyCLL()
    {
        this.First = null;
        this.Last = null;
        this.iCount = 0;
    }

    public void InsertFirst(int No)
    {
        Node newn = new Node(No);

        if(First == null && Last==null)
        {
            First = newn;
            Last = newn;
        }
        else
        {
            newn.Next = First;
            First.Prev = newn;
            First = newn;
        }
        iCount++;
        Last.Next = First;
        First.Prev = Last;
    }

    public void InsertLast(int No)
    {
        Node newn = new Node(No);

        if(First == null && Last == null)
        {
            First = newn;
            Last = newn;
        }
        else
        {
            Last.Next = newn;
            newn.Prev = Last;
            Last = newn;
        }
        iCount++;
        Last.Next = First;
        First.Prev = Last;
    }

    public void InsertAtPos(int No, int iPos)
    {
        if(iPos < 0 || iPos > iCount+1)
        {
            return;
        }
        if(iPos == 1)
        {
            InsertFirst(No);
        }
        else if(iPos == iCount+1)
        {
            InsertLast(No);
        }
        else
        {
            Node newn = new Node(No);
            Node temp = First;
            for(int iCnt=1; iCnt<iPos-1; iCnt++)
            {
                temp = temp.Next;
            }
            newn.Next = temp.Next;
            temp.Next.Prev = newn;

            newn.Prev = temp;
            temp.Next = newn;
            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if(First == null && Last == null)
        {
            return;
        }
        else if(First == Last)
        {
            First = null;
            Last = null;
        }
        else
        {
            First = First.Next;
            
            First.Prev = Last;
            Last.Next = First;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        if(First == null && Last == null)
        {
            return;
        }
        else if(First==null && Last == null)
        {
            First = null;
            Last = null;
        }
        else
        {
            Last = Last.Prev;

            Last.Next = First;
            First.Prev = Last;
        }
        iCount--;
    }

    public void DeleteAtPos(int iPos)
    {
        if(iPos < 0 || iPos > iCount)
        {
            return;
        }
        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            Node temp = First;
            for(int iCnt=1; iCnt<iPos-1; iCnt++)
            {
                temp = temp.Next;
            }
            temp.Next = temp.Next.Next;
            temp.Next.Prev = temp;
            iCount--;
        }
    }

    public void Display()
    {
        Node temp = First;
        System.out.println("Elements of linked list are :");
        for(int iCnt=1; iCnt<=iCount; iCnt++)
        {
            System.out.print("| " + temp.data + " | ->");
            temp = temp.Next;
        }
        System.out.println("null");
    }

    public int Count()
    {
        return iCount;
    }
}
public class DoublyCircularLinkedList {
    public static void main(String[] args) {

        DoublyCLL obj = new DoublyCLL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);
        obj.InsertLast(101);
        obj.InsertLast(111);

        obj.Display();
        System.out.println("Number of Nodes : " + obj.Count());

        obj.DeleteAtPos(3);
        obj.InsertAtPos(71, 3);

        obj.Display();
        System.out.println("Number of Nodes : " + obj.Count());

        obj.DeleteFirst();
        obj.DeleteLast();

        obj.Display();
        System.out.println("Number of Nodes : " + obj.Count());

    }
}
