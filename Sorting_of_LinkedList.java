import java.util.Scanner;
class Node
{
    int data; 
    Node next;
    Node(int val) 
    { 
        data = val; 
        next = null; 
    } 
}
public class Creation_Of_Linked_List
{
    static Node add(int data) 
    { 
        Node newnode = new Node(data);
        newnode.data = data; 
        newnode.next = null; 
        return newnode; 
    } 
    static Node addElements(int[] arr, Node head,int len) 
    { 
        head = add(arr[0]); 
        Node curr = head; 
        for (int index=1;index<len;index++) 
        { 
            curr.next=add(arr[index]); 
            curr=curr.next; 
        } 
        return head; 
    }
    static void sortLinkedList(Node head) 
    {  
        Node current = head, index = null;  
        int temp;  
        if(head == null)
        return;  
        else 
        {  
            while(current != null) 
            {  
                index = current.next;  
                while(index != null) 
                {  
                    if(current.data > index.data) 
                    {  
                        temp = current.data;  
                        current.data = index.data;  
                        index.data = temp;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }      
        }  
    }  
    static void print(Node head) 
    { 
        Node curr = head; 
        while (curr != null) 
        { 
            System.out.print(curr.data);
            System.out.print("->"); 
            curr = curr.next; 
        }
    }
    public static void main(String args[]) 
    {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int index=0;index<N;index++)
        {
        	arr[index]=sc.nextInt();
        }
        Node head = null; 
        head = addElements(arr,head,N);
        System.out.println("Linked List Before Sorting: ");
        print(head);
        System.out.println();
        sortLinkedList(head);
        System.out.println("Linked List After Sorting: ");
        print(head);
        sc.close();
    }
}