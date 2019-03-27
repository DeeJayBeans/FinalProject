import java.util.Scanner;
import java.io.*;
import java.util.*; 

public class LinkedList{
	public Node head;
	public Node tail;
	public int size;


	public LinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void Register(Node a){
		if(!isEmpty()){
			tail.link = a;
			tail = tail.link;
		}
		else{
			head = tail = a;
		}
	}
	
	public void SendMoney(Node fromdaque){
		int sender = fromdaque.accnum;
		int reciever = fromdaque.accnum;
		float amount = fromdaque.bal;
		float fee = amount*0.01f;
		float total = amount+fee;
		boolean check = false;
		Node discurrent;
		discurrent = this.head;
		if(head != null){
			if(amount < 0){
				for(int i = 0; discurrent != null; i++){
					if(discurrent.accnum == sender){
						if(discurrent.bal > ((total*-1f))){
							discurrent.bal = discurrent.bal + amount + fee;
							check = true;
						}
						else{
							System.out.println("Bounced. Insufficient Funds");
						}
						break;
					}
					discurrent = discurrent.link;
				}
			}
			else{
			discurrent = this.head;
				for(int i = 0; discurrent != null; i++){
					if(discurrent.accnum == reciever && check){
						discurrent.bal = discurrent.bal + amount;
					}
					discurrent = discurrent.link;
				}
			}				
		}
	}
	
	public void Display(){
		Node discurrent;
		discurrent = this.head;
		if(head != null){
			for(int i = 0; discurrent != null; i++){
				System.out.println(discurrent.accnum + " - " + discurrent.name);
				System.out.println("    " + discurrent.bal);				
				System.out.println("    #" + discurrent.accnum);
				discurrent = discurrent.link;
			}
		}
		else{
			System.out.println("There are no users");
		}
  }
	public static void promptEnterKey(){
		System.out.println("Press ENTER to continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}  
}
  