import java.util.Scanner;
class Node
{
    int data;
    Node next=null;
    Node(int val)
    {
        this.data=val;
        this.next=null;
    }
}
class Queue
{
    static Node front=null,rear=null;
    public static boolean isEmpty()
    {
        if(front==null&&rear==null)
        return true;
        else
        return false;
    }
    public static void enqueue(int element)
    {
        Node newNode=new Node(element);
        if(front==null)
        {
            front=newNode;
            rear=newNode;
        }
        else
        {
            rear.next=newNode;
            rear=newNode;
        }
    }
    public static int peek()
    {
        if(isEmpty())
        {
            System.out.print("Queue is empty");
            return -1;
        }
        else
        return front.data;
    }
    public static void dequeue()
    {
        if(isEmpty())
        {
            System.out.print("Queue is empty");
            return;
        }
        else
        {
            Node tempNode=front;
            front=front.next;
            if(front==null)
            rear=null;
            System.out.print(tempNode.data+" ");
        }
    }
}
public class Main 
{
    public static void main(String args[]) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Elements: ");
        int N=sc.nextInt();
        System.out.println("Enter the Elements: ");
        Queue queue=new Queue();
        for(int index=1;index<=N;index++)
        {
            queue.enqueue(sc.nextInt());
        }
        System.out.println("Front Element: "+queue.peek());
        System.out.println("Inserted Elements in the queue are: ");
        while(!queue.isEmpty())
        {
            queue.dequeue();
        }
    }
}