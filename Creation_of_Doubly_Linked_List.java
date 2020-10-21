import java.util.Scanner;
class Node
{
    int data; 
    Node next;
    Node previous;
    Node(int val) 
    { 
        this.data = val; 
    } 
}
public class Creation_of_Double_Linked_List
{
    static Node addElements(Node head,Node tail,int[] arr,int len) 
    {
        for (int index=0;index<len;index++) 
        { 
            Node newNode = new Node(arr[index]);
            if(head == null)
            {
                head = tail = newNode;
                head.previous = null;
                tail.next = null;
            }
            else
            {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
                tail.next = null;
            }
        } 
        return head;
    } 
    static void print(Node head) 
    { 
        Node curr = head; 
        if(head == null)
        {
            System.out.print("Empty List");
            return;
        }
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
        Node tail = null;
        head = addElements(head,tail,arr,N);
        System.out.println("Linked List Created is: ");
        print(head);
        sc.close();
    }
}