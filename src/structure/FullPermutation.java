package structure;

import java.util.*;

import homework_5.AStack;

public class FullPermutation {
	
	public static void main(String[] args){
		List<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		list.add('c');
		permutation(list);
	}

	private static void permutation(List<Character> list) {
		// TODO 自动生成的方法存根
		
		AStack stack = new AStack();
		State temp = new State(0, 0, 0);
		
		for(int i = 0;i < list.size(); i++){
			stack.push(new State(0, i, 0));
		}
		while(!stack.empty()){
			temp = (State) stack.pop();
			if(temp.i == list.size() - 1){
				System.out.println(list);
			}
			else{
				Collections.swap(list, temp.i , temp.j);
				if(temp.n == 0){
					temp.n += 1;
					stack.push(temp);
					int k = temp.i + 1;
					for(int m = k; m < list.size() ; ++m){
						stack.push(new State(k, m ,0));
					}
				}
			}
		}
	}
	
	
}
