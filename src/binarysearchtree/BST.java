package binarysearchtree;

import java.io.IOException;
import java.io.PrintWriter;

public interface BST<K extends Comparable<K>, V> {
	
	public void insert(Comparable key, String value);
	
	public String remove(Comparable key);
	
	public String search(Comparable key);
	
	public boolean update(Comparable key, String value);
	
	public boolean isEmpty();
	
	public void clear();
	
	public void showStructure(PrintWriter pw) throws IOException;
	
	public void printInorder(PrintWriter pw) throws IOException;
}
