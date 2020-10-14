import java.util.Scanner;
public class Count_Nodes_LinkedList
{
	static class Node
	{
	    int data; 
	    Node next;
	    Node(int val) 
	    { 
	        data = val; 
	        next = null; 
	    } 
	}
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
    static int count(Node head) 
    {
        int count=0;
	    while(head!=null)
	    {
	        head=head.next;
	        count++;
	    }
	    return count;
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
        System.out.println("Normal Output: ");
        print(head);
        System.out.print("\n\n");
        System.out.println("Number of Nodes in the Linked List are : "+count(head));
        sc.close();
    }
}