package structure;

public class AQueue {
	
	private static final int defaultSize = 500;
	
	private int size;
	
	private int font;
	
	private int rear;
	
	private Object[] listArray;
	
	public AQueue() {
		// TODO �Զ����ɵĹ��캯�����
		init(defaultSize);
	}
	
	public AQueue(int sz) {
		// TODO �Զ����ɵĹ��캯�����
		init(sz);
	}
	
	private void init(int sz) {
		// TODO �Զ����ɵķ������
		size = sz + 1;
		font = rear = 0;
		listArray = new Object[size];
	}
	
	public void enqueue(Object it){
		if(((rear+1) % size) != font){
			rear = (rear + 1) % size;
			listArray[rear] = it;
		} 
	}
	
	public Object dequeue(){
		if(rear != font){
			font = (font + 1) % size;
			return listArray[font];
		}else
			return 0;
	}
	
	public Object firstValue(){
		if(rear != font){
			return listArray[(font + 1) % size];
		}else
			return 0;
	}

	public boolean empty(){
		return font == rear;
	}
}
