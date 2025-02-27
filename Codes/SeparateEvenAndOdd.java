import java.util.*;
 class node{
	int data;
	node next;
	node(int d)
	{
		data=d;
		next=null;
	}
}
 class LL
 {
	 node head=null;
	 void insert(int d)
	 {
		 node newn=new node(d);
		 if(head==null)
		 {
			 head=newn;
		 }
		 else
		 {
			 node temp=head;
			 while(temp.next!=null)
			 {
				 temp=temp.next;
			 }
			 temp.next=newn;
		 }
	 }
	 void segregate()
	 {
	      node es=null;
	      node ee=null;
	      node os=null;
	      node oe=null;
	      node temp=head;
	      while(temp!=null)
	      {
	           if(temp.data%2==0)
	           {
	                if(es==null)
	                {
	                     es=ee=temp;
	                }
	                else{
	                     ee.next=temp;
	                     ee=ee.next;
	                }
	           }
	           else{
	                if(os==null)
	                {
	                     os=oe=temp;
	                }
	                else{
	                     oe.next=temp;
	                     oe=oe.next;
	                }
	           }
	           temp=temp.next;
	      }
	      if(es==null)
	      {
	           head=os;
	      }
	      else if(os==null)
	      {
	           head=es;
	           ee.next=null;
	      }
	      else{
	      head=es;
	      ee.next=os;
	      oe.next=null;
	      }
	 }
	 void display()
	 {
	      node temp=head;
	      while(temp!=null)
	      {
	           System.out.print(temp.data+" ");
	           temp=temp.next;
	      }
	 }
 }
public class SeparateEvenAndOdd {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LL l=new LL();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			int d=sc.nextInt();
			l.insert(d);
			}
	//	int s=sc.nextInt();
		//l.createloop(s);
		//l.display();
		//System.out.println((l.loopdetect())?"Yes":"No");
		//l.display(l.head);
		l.segregate();
		l.display();
		

	}

	 

}
