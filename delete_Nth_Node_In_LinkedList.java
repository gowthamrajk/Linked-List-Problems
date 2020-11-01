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
    static void deleteNode(Node head,int pos)
    {
        if(head==null)
        return;
        Node temp=head;
        if(pos==0)
        {
            head=temp.next;
            return;
        }
        for(int index=0;temp!=null&index<pos-1;index++)
        {
            temp=temp.next;
        }
        if(temp==null||temp.next==null)
        return;
        Node nextNode=temp.next.next;
        temp.next=nextNode;
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
        System.out.println("Linked List Created is: ");
        print(head);
        System.out.println();
        System.out.println("Enter the poisiton where node to be deleted: ");
        int K=sc.nextInt();
        deleteNode(head,K);
        print(head);
        sc.close();
    }
}