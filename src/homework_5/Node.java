package homework_5;

public class Node {
	char data;
	
	Node left;
	
	Node right;
	
	Node(char data){
		this(data, null ,null);
	}
	
	Node(char data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
