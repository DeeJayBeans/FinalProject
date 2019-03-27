import java.util.Scanner;
import java.io.*;
import java.util.*; 

public class Queue{
	public Node head;
	public Node tail;
	public int size;
	
	Scanner input = new Scanner(System.in);
	
	
	public Queue(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void Register(String n, float b, int acc, int a){
		if(!isEmpty()){
			tail.link = new Node(n,b,acc,a);
			tail = tail.link;
		}
		else{
			head = tail = new Node(n,b,acc,a);
		}
	}
	public void SendMoney(){
		int sender = input.nextInt();
		System.out.println("Select a user to recieve money: ");
		int reciever = input.nextInt();
		System.out.println("Amount to be sent: ");
		float amount = input.nextFloat();
		float fee = amount*0.01f;
		System.out.println("This will incur a "+fee+" fee. Continue?");
		promptEnterKey();	
		
				if(!isEmpty()){
					tail.link = new Node("Acc#"+sender,-amount,sender, 2);
					tail = tail.link;
					tail.link = new Node("Acc#"+reciever,amount,reciever, 3);
					tail = tail.link;
				}
				else{
					head = tail = new Node("Acc#"+sender,-amount,sender, 2);
					tail.link = new Node("Acc#"+reciever,amount,reciever, 3);
					tail = tail.link;
				}
	}
	
	public Node dequeue(){
		Node temp = new Node();
		temp = head;
		if(head == null){
			System.out.println("---------------------------------------");
			System.out.println("No pending tasks.");
		}
		else{
			head = head.link;
		}
		
		return temp;
	}
	public void Display(){
		Node discurrent;
		discurrent = this.head;
		if(head != null){
			for(int i = 0; discurrent != null; i++){
				if(discurrent.act == 1){
					System.out.println(i + " - Register User");
				}
				else if(discurrent.act == 2){
					System.out.println(i + " - Send Money (outgoing)");
				}
				else if(discurrent.act == 3){
					System.out.println(i + " - Send Money (incoming)");
				}
				System.out.println("    " + discurrent.name);
				System.out.println("    " + discurrent.bal);
				discurrent = discurrent.link;
			}
		}
		else{
			System.out.println("There are no queued tasks");
		}
  }
  	public static void promptEnterKey(){
		System.out.println("Press ENTER to continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}  
	
}
  