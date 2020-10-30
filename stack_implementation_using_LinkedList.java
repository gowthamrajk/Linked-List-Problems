import java.util.Scanner;
class Node
{
    int data;
    Node next=null;
}
class Stack
{
    static Node top=null;
    public static boolean isEmpty()
    {
        if(top==null)
        return true;
        else
        return false;
    }
    public static void push(int element)
    {
        Node newNode=new Node();
        if(newNode==null)
        {
            System.out.print("Stack is Full");
            return;
        }
        else
        {
            newNode.data=element;
            newNode.next=top;
            top=newNode;
        }
    }
    public static int peek()
    {
        if(isEmpty())
        {
            System.out.print("Stack is empty");
            return -1;
        }
        else
        return top.data;
    }
    public static void pop()
    {
        if(isEmpty())
        {
            System.out.print("Stack is empty");
            return;
        }
        else
        {
            System.out.print(peek()+" ");
            top=top.next;
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
        Stack stack=new Stack();
        for(int index=1;index<=N;index++)
        {
            stack.push(sc.nextInt());
        }
        System.out.println("Top Element: "+stack.peek());
        System.out.println("Inserted Elements in the stack are: ");
        while(!stack.isEmpty())
        {
            stack.pop();
        }
    }
}