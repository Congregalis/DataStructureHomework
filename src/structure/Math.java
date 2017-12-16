package structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import homework_5.AStack;

public class Math {
	public static char[] op = {'+','-','*','/','(',')'};  
    public static String[] strOp = {"+","-","*","/","(",")"};  
    
    public static boolean isDigit(char c){  
        if(c>='0'&&c<='9'){  
            return true;  
        }  
        return false;  
    }  
    public static boolean isOp(char c){  
        for(int i = 0; i < op.length; i++){  
            if(op[i] == c){  
                return true;  
            }  
        }  
        return false;  
    }  
    public static boolean isOp(String s){  
        for(int i = 0; i < strOp.length; i++){  
            if(strOp[i].equals(s)){  
                return true;  
            }  
        }  
        return false;  
    }  
    /** 
     * ��������ļ���ʽ 
     * @param str 
     * @return 
     */  
    public static List<String> work(String str){  
        List<String> list = new ArrayList<String>();  
        char c;  
        StringBuilder sb = new StringBuilder();  
        for(int i = 0; i < str.length(); i++){  
            c = str.charAt(i);  
            if(isDigit(c)){  
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
    
//    public String[] haiShen(String str){
//    	char[] ch = str.toCharArray();
//    	ArrayList<String> arr = new ArrayList<>();
//    	for(int i = 0; i < ch.length; i++) {
//    		if(!isOp(ch[i])) {
//    			
//    		}else {
//    			
//    		}
//    	}
//    }
    /** 
     * ��׺���ʽת��Ϊ��׺���ʽ 
     * 1,����������� 
     * 2,���������ȼ���ȫ����ջ 
     * 3,���ȫ����ջ 
     */  
    public static List<String> InfixToPostfix(List<String> list){  
        List<String> Postfixlist = new ArrayList<String>();//��ź�׺���ʽ  
        AStack stack = new AStack();//�ݴ������  
        //stack.push('#');  
        for(int i = 0; i < list.size();i++){  
              
            String s = list.get(i);  
            if(s.equals("(")){  
                stack.push(s);  
            }else if(s.equals("*")||s.equals("/")){  
                stack.push(s);  
            }else if(s.equals("+")||s.equals("-")){  
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
            if(i == list.size()-1){  
                while(!stack.empty()){  
                    Postfixlist.add((String) stack.pop());  
                }  
            }  
        }  
        return Postfixlist;  
    }  
    /** 
     * ��׺���ʽ���� 
     */  
    public static float doCal(List<String> list){  
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
                    float v = a2+a1;  
                    stack.push(v);  
                }else if(s.equals("-")){  
                	float a1 = (float) stack.pop();  
                	float a2 = (float) stack.pop();
                	float v = a2-a1;  
                    stack.push(v);  
                }else if(s.equals("*")){  
                	float a1 = (float) stack.pop();  
                	float a2 = (float) stack.pop();  
                	float v = a2*a1;  
                    stack.push(v);  
                }else if(s.equals("/")){  
                	float a1 = (float) stack.pop();  
                	float a2 = (float) stack.pop();  
                	float v = a2/a1;  
                    stack.push(v);  
                }  
            }  
        }  
        return (float) stack.pop();  
    } 
    
    public static void main(String[] args){
    	String str = "9+(3-1)*3+10/2";
    	List<String> list = work(str);
    	List<String> list2 = InfixToPostfix(list);
    	System.out.println(doCal(list2));
	}
	
}

