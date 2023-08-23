#include<stdio.h>
#include<stdlib.h>

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Structure declaration for node of a linked list
/////////////////////////////////////////////////////////////////////////////////////////////////////

typedef struct Node
{
    int data;
    struct Node *next;
}NODE, *PNODE, **PPNODE;

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Function to insert element at first position of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

void InsertFirst(PPNODE Head, int no)
{
    PNODE newn = NULL;
    newn = (PNODE)malloc(sizeof(NODE));         

    newn->data = no;                            
    newn->next = NULL;

    if(*Head == NULL)                          
    {
        *Head = newn;                           
    }
    else
    {
        newn->next = *Head;                     
        *Head = newn;                           
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Function to insert element at last position of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

void InsertLast(PPNODE Head, int no)
{
    PNODE newn = NULL;
    newn = (PNODE)malloc(sizeof(NODE));         

    PNODE temp = *Head;

    newn->data = no;                            
    newn->next = NULL;

    if(*Head == NULL)                           
    {
        *Head = newn;                           
    }
    else
    {
        while(temp -> next != NULL)
        {
            temp = temp -> next;
        }
        temp->next = newn;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Function to Display elements of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

void Display(PNODE Head)
{
    printf("Elements of LinkedList are : \n");

    while(Head != NULL)
    {
        printf("| %d | -> ",Head->data);
        Head = Head -> next;
    }
    printf("NULL \n");
}

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Function to calculate number of elements in Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

int Count(PNODE Head)
{
    int iCount = 0;

    while(Head != NULL)
    {
        iCount++;
        Head = Head -> next;
    }
    return iCount;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Function to delete first element of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

void DeleteFirst(PPNODE Head)
{
    PNODE temp = *Head;
    
    if(*Head == NULL)               // LL is empty           
    {
        return;
    }
    else if((*Head) -> next == NULL)    // LL contains 1 node
    {
        free(*Head);
        *Head = NULL;
    }
    else                            // LL contains more than one node
    {
        *Head = (*Head) -> next;
        free(temp);
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Function to delete last element of Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

void DeleteLast(PPNODE Head)
{
    PNODE temp = *Head;

    if(*Head == NULL)               // LL is empty           
    {
        return;
    }
    else if((*Head) -> next == NULL)    // LL contains 1 node
    {
        free(*Head);
        *Head = NULL;
    }
    else                            // LL contains more than one node
    {
        while(temp->next->next != NULL)      
        {
            temp = temp->next;
        }  

        free(temp->next);
        temp->next = NULL;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Function to insert element at specified position in Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

void InsertAtPos(PPNODE Head, int no, int ipos)
{
    int iLength = 0;
    iLength = Count(*Head);     // Calculate length of LL

    PNODE newn = NULL;
    int icnt = 0;
    PNODE temp = *Head;

    // Filter
    if((ipos < 1) || (ipos > iLength + 1))      // Invalid position
    {
        printf("Invalid position\n");
        return;
    }

    if(ipos == 1)
    {
        InsertFirst(Head,no);
    }
    else if(ipos == iLength+1)
    {
        InsertLast(Head,no);
    }
    else
    {
        newn = (PNODE)malloc(sizeof(NODE));        

        newn->data = no;                           
        newn->next = NULL;    

        for(icnt = 1; icnt < ipos-1; icnt++)
        {
	        temp = temp -> next;
        }

        // Sequance is important
        newn->next = temp->next;
        temp->next = newn;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Function to delete element at specified position in Singly Linear Linked List
/////////////////////////////////////////////////////////////////////////////////////////////////////

void DeleteAtPos(PPNODE Head, int ipos)
{
    int iLength = 0;
    iLength = Count(*Head);     // Calculate length of LL

    PNODE temp = *Head;
    PNODE tempX = NULL;

    int icnt = 0;
    
    // Filter
    if((ipos < 1) || (ipos > iLength))      // Invalid position
    {
        printf("Invalid position\n");
        return;
    }

    if(ipos == 1)
    {
        DeleteFirst(Head);
    }
    else if(ipos == iLength)
    {
        DeleteLast(Head);
    }
    else
    {
        for(icnt = 1; icnt < ipos-1; icnt++)
        {
	        temp = temp -> next;
        }  

        tempX = temp->next;

        temp->next = temp->next->next;
        free(tempX);
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////
// Entry Point Function/Main Function
/////////////////////////////////////////////////////////////////////////////////////////////////////
int main()
{
    PNODE First = NULL;
    int iRet = 0;

    InsertLast(&First, 11);
    InsertLast(&First, 21);
    InsertLast(&First, 51);
    InsertLast(&First, 101);

    Display(First);

    iRet = Count(First);
    printf("Number of nodes are : %d\n",iRet);

    InsertFirst(&First,10);
    InsertFirst(&First,20);

    InsertAtPos(&First, 25, 5);

    Display(First);

    iRet = Count(First);
    printf("Number of nodes are : %d\n",iRet);
    
    DeleteAtPos(&First, 5);

    Display(First);

    iRet = Count(First);
    printf("Number of nodes are : %d\n",iRet);
    
    DeleteFirst(&First);
    DeleteFirst(&First);

    Display(First);

    iRet = Count(First);
    printf("Number of nodes are : %d\n",iRet);

    DeleteLast(&First);
    Display(First);

    iRet = Count(First);
    printf("Number of nodes are : %d\n",iRet);

    return 0;
}