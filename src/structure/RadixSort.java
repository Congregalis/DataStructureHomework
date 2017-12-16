package structure;

public class RadixSort {
	public int[] sort(int[] arr) {
		if(arr == null) {
			return null;
		}
		
		int maxLen = maxLen(arr);
		return sortCore(arr, 0, maxLen);
	}

	private int[] sortCore(int[] arr, int digit, int maxLen) {
		// TODO �Զ����ɵķ������
		
		// ***�˴��еط�˵ӦΪdigit >= manLen ,��������>��������ʱδ���ִ���***
		if(digit > maxLen) {
			return arr;
		}
		
		final int radix = 10;
		int[] count = new int[10];
		int[] bucket = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			count[getDigit(arr[i], digit)]++;
		}
		
		for(int i = 1; i < radix; i++) {
			count[i] += count[i-1];
		}
		
		for(int i = arr.length - 1; i >= 0; i--) {
			bucket[count[getDigit(arr[i], digit)] - 1] = arr[i];
			count[getDigit(arr[i], digit)]--;
		}
		
		return sortCore(bucket, digit+1, maxLen);
	}
	
	//�����ַ�������
	public String[] sort(String[] str) {
		if(str == null) {
			return null;
		}
		
		int maxLen = maxLen(str);
		return sortCore(str, maxLen-1, maxLen);
	}

	private String[] sortCore(String[] str, int digit, int maxLen) {
		// TODO �Զ����ɵķ������
		if(digit < 0) {
			return str;
		}
		
		final int radix = 27;
		int[] count = new int[radix];
		String[] bucket = new String[str.length];
		
		for(int i = 0; i < str.length; i++) {
			count[getDigit(str[i], digit)]++;
		}
		
		for(int i = 1; i < radix; i++) {
			count[i] += count[i-1];
		}
		
		for(int i = str.length - 1; i >= 0; i--) {
			bucket[count[getDigit(str[i], digit)] - 1] = str[i];
			count[getDigit(str[i], digit)]--;
		}
		
		return sortCore(bucket, digit-1, maxLen);
	}

	//��ȡһ����i��digitλ�ϵ�����
	private int getDigit(int i, int digit) {
		// TODO �Զ����ɵķ������
		int[] num = {1, 10, 100, 1000, 10000, 100000, 10000000, 100000000, 1000000000};
		return (i / num[digit]) % 10;
	}
	
	//��ȡһ���ַ���i��digitλ�ϵ���ĸ
	private int getDigit(String i, int digit) {
		// TODO �Զ����ɵķ������
		char[] a = i.toCharArray();
		if(digit >= a.length) {
			return 0;
		}
		else{
			return a[digit] - 'a' + 1;
		}
	}

	//��ȡ������ֵ�λ��
	private int maxLen(int[] arr) {
		// TODO �Զ����ɵķ������
		int maxLen = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int currLen = len(arr[i]);
			if(currLen > maxLen) {
				maxLen = currLen;
			}
		}
		
		return maxLen;
	}
	
	private int maxLen(String[] str) {
		int maxLen = 0;
		
		for(int i = 0; i < str.length; i++) {
			int currLen = len(str[i]);
			if(currLen > maxLen) {
				maxLen = currLen;
			}
		}
		
		return maxLen;
	}

	//��ȡһ������λ��
	private int len(int i) {
		// TODO �Զ����ɵķ������
		return String.valueOf(i).length();
	}
	
	private int len(String string) {
		// TODO �Զ����ɵķ������
		return string.length();
	}
	
	//���Խ��
	public static void main(String[] args) {
		int[] arr = {123, 5387, 253, 2456, 142, 231, 110, 3666, 1206};
		String[] str = {"abce", "cabb", "bdea", "fad", "abd", "bed", "fdd", "abe", "abda", "aaaaa"};
		RadixSort rs = new RadixSort();
		arr = rs.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		str = rs.sort(str);
		for(int i = 0; i < str.length; i++) {
			System.out.print(str[i] + " ");
		}
	}
}
