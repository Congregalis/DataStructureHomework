package binarysearchtree;

import java.io.IOException;
import java.io.PrintWriter;

public class ABST implements BST {

	private BinNode root;
	
	private String removeValue;
	
	public ABST() {
		root = null;
	}
	
	@Override
	public void insert(Comparable key, String value) {
		// TODO 自动生成的方法存根
		root = insert(key, value, root);
	}

	@Override
	public String remove(Comparable key) {
		// TODO 自动生成的方法存根
		root = remove(key, root);
		return removeValue;
	}

	@Override
	public String search(Comparable key) {
		// TODO 自动生成的方法存根
		return search(key, root);
	}

	@Override
	public boolean update(Comparable key, String value) {
		// TODO 自动生成的方法存根
		return updata(key, value, root);
	}

	@Override
	public boolean isEmpty() {
		// TODO 自动生成的方法存根
		return root == null;
	}

	@Override
	public void clear() {
		// TODO 自动生成的方法存根
		root = null;
	}

	@Override
	public void showStructure(PrintWriter pw) throws IOException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void printInorder(PrintWriter pw) throws IOException {
		// TODO 自动生成的方法存根
		
	}
	
	private String search(Comparable key, BinNode t) {
		// TODO 自动生成的方法存根
		if ( t == null) {
			return null;
		}
		
		int compareResult = key.compareTo(t.key);
		
		if (compareResult < 0)
			return search(key, t.left);
		else if (compareResult > 0)
			return search(key, t.right);
		else 
			return t.value;
	}
	
	private BinNode insert(Comparable key, String value, BinNode t) {
		// TODO 自动生成的方法存根
		
		if(key == null || value == null)
			return null;
		
		if (t == null)
			return new BinNode(key, value, null, null);
		
		int compareResult = key.compareTo(t.key);
		
		if (compareResult < 0)
			t.left = insert(key, value, t.left);
		else if (compareResult > 0)
			t.right = insert(key, value, t.right);
		else
			t.value = value;
		
		return t;
	}

	private boolean updata(Comparable key, String value, BinNode t) {
		// TODO 自动生成的方法存根
		if (key == null || value == null) {
			return false;
		}
		
		if(t == null)
			return false;
		
		int comparableResult = key.compareTo(t.key);
		
		if (comparableResult < 0)
			return updata(key, value, t.left);
		else if (comparableResult > 0)
			return updata(key, value, t.right);
		else{
			t.value = value;
			return true;
		}
	}
	
	private BinNode remove(Comparable key, BinNode t) {
		// TODO 自动生成的方法存根
		if(key == null)
			return null;
		
		int comparableResult = key.compareTo(t.key);
		
		if (comparableResult < 0)
			t.left = remove(key, t.left);
		else if (comparableResult > 0)
			t.right = remove(key, t.right);
		else if (t.left != null && t.right != null) {
			t.key = findMin(t).key;
			t.value = findMin(t).value;
			t.right = remove(t.key, t.right);
			removeValue = t.value;
		}
		else {
			t = (t.left != null) ? t.left : t.right;
			removeValue = t.value;
		}
		return t;
	}
	
	private BinNode findMin(BinNode t) {
		if (t == null)
			return null;
		else if (t.left == null)
			return t;
		
		return findMin(t.left);
	}
	
	private int getCount(BinNode t) {
		int count = 0;
		
		if (t == null)
			return count;
		
		return getCount(t.left) + getCount(t.right) + 1;
	}
	
	private int getHeight(BinNode t) {
		int count = 0;
		
		if (t == null)
			return count;
		
		return (getHeight(t.left) > getHeight(t.right)) ? getHeight(t.left)+1 : getHeight(t.right)+1;
	}
}
