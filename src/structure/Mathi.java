package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import homework_5.AStack;

public class Mathi {
	public static char[] op = {'+','-','*','/','(',')'};  
	public static String[] strOp = {"+","-","*","/","(",")"};  
	
	public boolean isOp(char c){  
		for(int i = 0; i < op.length; i++){  
			if(op[i] == c){  
				return true;  
			}
		}
		return false;  
	}
	
	public boolean isOp(String s){  
		for(int i=0;i<strOp.length;i++){  
			if(strOp[i].equals(s)){  
				return true;  
			}
		}
		return false;  
	}
	
	public List<String> work(String str){  
		List<String> list = new ArrayList<String>();  
		char c;  
		StringBuilder sb = new StringBuilder();  
		for(int i = 0; i < str.length(); i++){  
			c = str.charAt(i);
			if(!isOp(c)){  
				sb.append(c);  
			}
			if(isOp(c)){  
				if(sb.toString().length() > 0){  
					list.add(sb.toString());  
					sb.delete(0, sb.toString().length()); 
				}
				list.add(c+"");  
			}

		}
		if(sb.toString().length() > 0){  
			list.add(sb.toString());  
			sb.delete(0, sb.toString().length());  
		}
		return list;  
	 }
	
	 public void printList(List<String> list){  
		 for(String o:list){ 
			 System.out.print(o+" "); 
		 }
	 }
	 
	 public List<String> InfixToPostfix(List<String> list){  
		 List<String> Postfixlist = new ArrayList<String>();
		 AStack stack = new AStack();
		 for(int i = 0; i < list.size();i++){ 
			 String s = list.get(i);  
			 if(s.equals("(")){  
				 stack.push(s);  
			 }else if(s.equals("*") || s.equals("/")){  
				 stack.push(s); 
			 }else if(s.equals("+") || s.equals("-")){  
				 if(!stack.empty()){  
					 while(!(stack.topValue().equals("("))){ 
						 Postfixlist.add((String) stack.pop());
						 if(stack.empty()){ 
							 break;  
						 }
					 }
					 stack.push(s);  
				  }else{
					  stack.push(s);  
				  }
			 }else if(s.equals(")")){  
				 while(!(stack.topValue().equals("("))){ 
					 Postfixlist.add((String) stack.pop());  
				 }
				 stack.pop();  
			 }else{
				 Postfixlist.add(s); 
			 }
			 if(i == list.size() - 1){  
				 while(!stack.empty()){  
					 Postfixlist.add((String) stack.pop());  
				 }
			 }
		 }
		 return Postfixlist;  
	 }
	 public float doCal(List<String> list){  
		 AStack stack = new AStack();  
		 for(int i = 0; i < list.size(); i++){  
			 String s = list.get(i);  
			 float t = 0; 
			 if(!isOp(s)){  
				 t = Float.parseFloat(s);
				 stack.push(t);  
			 }else{
				 if(s.equals("+")){  
					 float a1 = (float) stack.pop(); 
					 float a2 = (float) stack.pop();  
					 float v = a2 + a1;  
					 stack.push(v);
				 }else if(s.equals("-")){  
					 float a1 = (float) stack.pop();
					 float a2 = (float) stack.pop();  
					 float v = a2 - a1;
					 stack.push(v);  
				 }else if(s.equals("*")){  
					 float a1 = (float) stack.pop();  
					 float a2 = (float) stack.pop();  
					 float v = a2 * a1;  
					 stack.push(v);
				 }else if(s.equals("/")){ 
					 float a1 = (float) stack.pop();
					 float a2 = (float) stack.pop();  
					 float v = a2 / a1;  
					 stack.push(v);  
				 }
			 }
		 }
		 return (float) stack.pop();  
	 }
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Mathi cal=new Mathi();
		System.out.println("请输入表达式： ");
		String input = getString();
		String formula = new String(input);
//		String input = "1.0+2.1*(2.9-1)";
//		String formula = new String(input);
		 List<String> list = cal.work(formula);  
		 List<String> list2 = cal.InfixToPostfix(list);  
		 System.out.println("原式为："+formula);
		 System.out.print("后缀表达式为：");  
		 cal.printList(list2);  
		 System.out.println(" ");  
		 System.out.println("计算结果为："+cal.doCal(list2));  

	}
	
	public static String getString() throws IOException{
		 InputStreamReader isr = new InputStreamReader(System.in 

);
		 BufferedReader br = new BufferedReader(isr);
		 String str = br.readLine();
		 return str;
	}

	public  String transfer2to10(String s){
		String s1=s.substring(2, s.length());
		String b=Integer.valueOf(s1,2).toString() ;
		return b;
	}
	public String transfer8to10(String s){
		String s1=s.substring(1, s.length());
		String b=Integer.valueOf(s1,8).toString() ;
		return b;
	}
	public String transfer16to10(String s){
		String s1=s.substring(2, s.length());
		String b=Integer.valueOf(s1,16).toString() ;
		return b;
	}

}
