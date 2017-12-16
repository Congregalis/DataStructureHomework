package homework_5;

public class AStack {
	
	private static final int defaultSize = 500;
	
	private int size;
	
	private int top;
	
	private Object[] listarray;
	
	public AStack() {
		// TODO 自动生成的构造函数存根
		init(defaultSize);
	}
	
	public void Astack(int sz){
		init(sz);
	}
	
	private void init(int sz) {
		// TODO 自动生成的方法存根
		size = sz;
		top = 0;
		listarray = new Object[size];
	}

	public void clear(){
		top = 0;
	}
	
	public void push(Object it){
		if(top < size){
			listarray[top++] = it;
		}
	}
	
	public Object pop(){
		if(top != 0){
			return listarray[--top];
		}
		else
			return 0;
	}
	
	public Object topValue(){
		if(top != 0){
			return listarray[top-1];
		}
		else
			return " ";
	}
	
	public boolean empty(){
		return top == 0;
	}
}
