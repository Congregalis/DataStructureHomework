package structure;

import homework_5.AStack;

public class Arithmetic {
	
	public static void main(String[] args){
		System.out.println(operation("1+2*3+4"));
	}
	
	private static double operation(String s){
		
		char[] data = new char[500];
		char[] temp = new char[10];
		AStack operatorStack = new AStack();
		AStack outputStack = new AStack();
		
		data = s.toCharArray();
		//将正常运算表达式转为后缀表达式
		for(int i = 0; i < data.length; i++){
			switch(data[i]){
				case '+':
					while(getpriority(operatorStack.topValue()) >= 1){
						outputStack.push(operatorStack.pop());
					}
					operatorStack.push('+');
					break;
				case '-':
					operatorStack.push('-');
					break;
				case '*':
					while(getpriority(operatorStack.topValue()) >= 2){
						outputStack.push(operatorStack.pop());
					}
					operatorStack.push('*');
					break;
				case '/':
					operatorStack.push('/');
					break;
				default:
					outputStack.push(data[i]);
					break;
			}
		}
		
		while(outputStack.topValue() != (Object)'`'){
			System.out.print(outputStack.pop());
		}
		return 0;
	}

	private static int getpriority(Object topValue) {
		// TODO 自动生成的方法存根
		if((Character)topValue == '+')
			return 1;
		else if((Character)topValue == '-')
			return 1;
		else if((Character)topValue == '*')
			return 2;
		else if((Character)topValue == '/')
			return 2;
		else if((Character)topValue == '(')
			return 0;
		else 
			return 0;
	}
	
}
