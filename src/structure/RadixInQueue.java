package structure;

import java.io.BufferedReader;
import java.io.FileReader;

public class RadixInQueue {
    private static String[] aux;
    
    private static int getDigit(String str,int digit){
        if(digit < str.length()) {
            if (str.charAt(digit) - 'A' <= 25) 
            	return str.charAt(digit) - 'A';
            else 
            	return str.charAt(digit) - 'a' + 26;
        }else 
        	return -1;
    }
    
    static void sort(String[] str){
        int maxLen = maxLen(str);
        AQueue[] bucket = new AQueue[53];
        for(int i = 0;i < 53;i++)
            bucket[i] = new AQueue();
        int digit = maxLen -1;
        int k = 0;
        int[] count = new int[53];
        while(digit >= 0 ){
            for(int i = 0;i < str.length;i++){
                int dight = getDigit(str[i], digit) + 1;
                bucket[dight].enqueue(str[i]);
                count[dight]++;
            }
            for(int i = 0; i < 53; i++) {
                if(count[i] != 0)
                    for(int j = 0; j < count[i]; j++)
                        {str[k] = (String)bucket[i].dequeue();k++;}
                count[i] = 0;
            }
           digit--;
           k = 0;
        }
    }
    
    //获取最大数字的位数
    private static int maxLen(String[] str) {
		int maxLen = 0;
		
		for(int i = 0; i < str.length; i++) {
			int currLen = len(str[i]);
			if(currLen > maxLen) {
				maxLen = currLen;
			}
		}
		
		return maxLen;
	}
    
    //获取一个字符串的长度
  	private static int len(String string) {
		// TODO 自动生成的方法存根
		return string.length();
	}
  	
    public static void main(String[] args){
//            BufferedReader in = new BufferedReader(new FileReader("C:/Users/DuanJinghai/Desktop/lab3_4_3.txt"));
//            String str = in.readLine();
//            String pass;
//            while((pass = in.readLine()) != null)
//                str+=pass;
//            String[] strings = str.trim().split("\\s+");
//            in.close();
            String[] stri = {"abce", "cabb", "bdea", "fad", "abd", "bed", "fdd", "abe", "abda", "aaaaa"};
            sort(stri);
//            System.out.println(strings.length);
            for(int i = 0;i < stri.length;i++)
                System.out.println(stri[i]);
//        } catch (java.io.IOException e) {
//            e.printStackTrace();
//        }
    }
}
