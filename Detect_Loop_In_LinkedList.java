import java.util.Scanner;
public class Detect_Loop_In_LinkedList
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
    static void createLoop(Node head,int index)
    {
        Node temp=head;
        Node backUP=null;
        int count=0;
        while(count<index)
        {
            temp=temp.next;
            count++;
        }
        backUP=temp;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=backUP;
    }
    static int detectLoop(Node head)
    {
        Node slowPointer=head;
        Node fastPointer=head;
        while(true)
        {
            if(slowPointer==null||fastPointer==null||fastPointer.next==null)
            {
                break;
            }
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
            if(slowPointer==fastPointer)
            {
                slowPointer=head;
                while(slowPointer!=fastPointer)
                {
                    slowPointer=slowPointer.next;
                    fastPointer=fastPointer.next;
                }
                return slowPointer.data;
            }
        }
        return 0;
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
        System.out.println("Enter the element from where loop has to be created: ");
        int loopPos=sc.nextInt();
        System.out.println(loopPos+"\n");
        createLoop(head,loopPos);
        System.out.println("Loop created successfully\n");
        if(detectLoop(head)==0)
        System.out.print("Loop not found");
        else
        System.out.println("Loop found at Node which has the value of \n"+detectLoop(head));
        sc.close();
    }
}