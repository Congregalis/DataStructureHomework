package homework_5;

import javax.xml.crypto.NodeSetData;

public class Calculater {
	
	public static char[] op = {'+','-','*','/','(',')'};  
	
	public static boolean isDigit(char c) {  
        if(c >= '0' && c <= '9'){  
            return true;  
        }  
        return false;  
    }  
	
    public static boolean isOp(char c) {  
        for(int i = 0; i < op.length; i++){  
            if(op[i] == c){  
                return true;  
            }  
        }  
        return false;  
    }  
    
    public static int getPriority(char c) {
    	switch(c) {
    	case '@':
    		return 0;
    	case '+' :
    		return 1;
    	case '-' :
    		return 1;
    	case '*' :
    		return 2;
    	case '/' :
    		return 2;
    	case '(':
    		return 3;
    	}
    	
    	return 3;
    }
    
    //中缀表达式转换为后缀表达式
    public static String InfixToPostfix(String infix) {
    	
    	char[] c = infix.toCharArray();
    	
    	AStack stack = new AStack();
    	
    	StringBuffer postfix = new StringBuffer();
    	
    	stack.push('@');
    	
    	for (int i = 0; i < infix.length(); i++) {
    		
    		if(c[i] == ')') {
    			while ((char) stack.topValue() != '@') {
    				postfix.append(stack.pop());
    			}
    			stack.pop();
    		}
    		
    		else if (isOp(c[i])) {
	    		while (getPriority((char) stack.topValue()) >= getPriority(c[i])) {
	    			postfix.append(stack.pop());
	    		}
	    		if ( c[i] == '(')	
	    			stack.push('@');
	    		else
	    			stack.push(c[i]);
    		}
    		else {
    			postfix.append(c[i]);
    		}
    	}
    	
    	while (getPriority((char) stack.topValue()) > 0) {
    		postfix.append(stack.pop());
    	}
    	
    	return postfix.toString();
    }
    
    //中缀转为二叉树
    public static Node InfixToTree(String infix) {
    	
    	char[] c = infix.toCharArray();
    	
    	AStack nodeStack = new AStack();
    	
    	AStack opStack = new AStack();
    	
    	opStack.push('@');
    	
    	for (int i = 0; i < infix.length(); i++) {
    		if (c[i] ==')') {
    			while ((char) opStack.topValue() != '@') {
    				nodeStack.push(new Node((char) opStack.pop(), (Node) nodeStack.pop(), (Node) nodeStack.pop()));
    			}
    			opStack.pop();
    		}
    		else if (isOp(c[i])) {
    			while (getPriority((char) opStack.topValue()) >= getPriority(c[i])) {
    				nodeStack.push(new Node((char) opStack.pop(), (Node) nodeStack.pop(), (Node) nodeStack.pop()));
    			}
    			if (c[i] == '(')
    				opStack.push('@');
    			else
    				opStack.push(c[i]);
    		}
    		else {
    			nodeStack.push(new Node(c[i]));
    		}
    	}
    	
    	while (getPriority((char) opStack.topValue()) > 0) {
    		nodeStack.push(new Node((char) opStack.pop(), (Node) nodeStack.pop(), (Node) nodeStack.pop()));
    	}
    	
    	return (Node) nodeStack.pop();
    }
    
    //中序遍历树得出计算结果
    public static int CalculateByTree(Node node) {
    	if (isOp(node.data)) {
    		switch (node.data) {
    		case '+':
    			return CalculateByTree(node.right) + CalculateByTree(node.left);
    		case '-':
    			return CalculateByTree(node.right) - CalculateByTree(node.left);
    		case '*':
    			return CalculateByTree(node.right) * CalculateByTree(node.left);
    		case '/':
    			return CalculateByTree(node.right) / CalculateByTree(node.left);
    		default:
    			return 0;
    		}
    	}
    	else {
    		return Character.getNumericValue(node.data);
    	}
    }
    
    public static void main(String[] args) {
//    	System.out.println(InfixToPostfix("3+4*(5+6)-3"));
//    	System.out.println(InfixToTree("3+4*(5+6)-3").data);
    	System.out.print("正确结果：");
    	System.out.println(3+4*(5+6)-3);
    	System.out.print("经表达式树计算结果：");
    	System.out.println(CalculateByTree(InfixToTree("3+4*(5+6)-3")));
    }
}
