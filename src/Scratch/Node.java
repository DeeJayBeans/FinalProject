public class Node{
	public String name;
	public float bal;
	public int act;
	public int accnum;
	public Node link;
	
	public Node(){
		name = "";
		bal = 0;
		act = 0;
		accnum = 0;
	}
	
	public Node(String n, float b, int a){
		this(n,b,a,null);
	}	
	
	public Node(String n, float b, int a, int acc){
		this(n,b,a,acc,null);
	}

	public Node(String n, float b, int a, Node na){
		name = n;
		bal = b;
		act = a;
		link = na;
	}
	
	public Node(String n, float b, int acc, int a, Node na){
		name = n;
		bal = b;
		act = a;
		accnum = acc;
		link = na;
	}
}