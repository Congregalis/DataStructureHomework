package binarysearchtree;

public class BinNode{
	
	Comparable key;
	
	String value;
	
	public BinNode left;
	
	public BinNode right;

	BinNode(Comparable key, String value){
		this(key, value, null ,null);
	}
	
	BinNode(Comparable key, String value, BinNode left, BinNode right) {
		// TODO 自动生成的构造函数存根
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
}
