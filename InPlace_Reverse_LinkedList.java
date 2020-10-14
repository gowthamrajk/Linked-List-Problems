import java.util.Scanner;
public class InPlace_Reverse_LinkedList
{
	static class Node
	{
	    char data; 
	    Node next;
	    Node(char val) 
	    { 
	        data = val; 
	        next = null; 
	    } 
	}
    static Node add(char data) 
    { 
        Node newnode = new Node(data);
        newnode.data = data; 
        newnode.next = null; 
        return newnode; 
    } 
    static Node addCharacters(String name, Node head,int len) 
    { 
        head = add(name.charAt(0)); 
        Node curr = head; 
        for (int index=1;index<len;index++) 
        { 
            curr.next=add(name.charAt(index)); 
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
    static Node printReverse(Node head)
    {
    	Node prev = null; 
        Node current = head; 
        Node next = null; 
        while (current != null) 
        { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        head= prev; 
        return head;
    }
    public static void main(String args[]) 
    {
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        int len=name.length();
        Node head = null; 
        head = addCharacters(name,head,len);
        System.out.println("Normal Output: ");
        print(head);
        System.out.print("\n\n");
        System.out.println("Reversed Output: ");
        head=printReverse(head);
        print(head);
        sc.close();
    }
}