/**
*		Names: DJ Renzo Emmanuel Bince
*			   Sheil Ann Ashley Bruas
*			   Lance Parantar
*
*		Section CC12/CC13 - CCA
*		Money Transfer Program
*
*/
import java.util.Scanner;
import java.io.*;
import java.util.*; 
public class MoneyTransfer{
	public static void main(String[] args) throws IOException{
		Queue q = new Queue();
		LinkedList LL = new LinkedList();
		boolean repeat = true;
		Scanner input = new Scanner(System.in);
		int choice = 0;
		int accnum = 0;
		while(repeat){
			decorline();
			menu();
			decorline();
			choice = input.nextInt();
			switch(choice){
				case 0:decorline();
						repeat = false;
						break;
						
				case 1: decorline();
						System.out.println("Enter name: ");
						String newName = input.next();
						System.out.println("Enter balance: ");
						float newBalance = input.nextFloat();
						q.Register(newName, newBalance, accnum, 1);
						accnum++;
						break;

				case 2: decorline();
						Node temp = q.dequeue();
						if(temp.act == 1){
							LL.Register(temp);
						}
						else{
							LL.SendMoney(temp);
						}
						break;
						
				case 3: decorline();
						if(LL.isEmpty()){
							System.out.print("No users available");
						}
						else{
						System.out.println("Select a user to send money: ");
						LL.Display();
						q.SendMoney();
						}
						break;

				case 4: decorline();
						q.Display();
						break;	
				
				case 5: decorline();
						LL.Display();
						break;
						
			}
		}
	}
	public static void menu(){
			System.out.println("0 - Exit Program");
			System.out.println("1 - Register New User");
			System.out.println("2 - Dequeue Task");
			System.out.println("3 - Transfer Money");
			System.out.println("4 - Display Pending Tasks");
			System.out.println("5 - Display All Existing Users");
			
	}
	public static void decorline(){
			System.out.println("---------------------------------------");
	}
}