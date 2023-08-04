import java.util.*;
import java.io.*;

public class Main {
	static int[] firstset = {2,3,5,7};
	static int[] secondset = {1,3,7,9};
	static int N;
	
	static public int checksosu(int num) {
		int cnt = 0;
		for(int i =1;i<=(int)Math.sqrt(num);i++) {
			if (num%i==0) {
				cnt +=1;
			}
			if (cnt >1) {
				break;
			}
		}
		if(cnt ==1) {
			return 1;
		}
		return 0;
	}
	
	static public void sosu(int cnt,int num) {
		if(cnt == N-1) {
			System.out.println(num);
			return;
		}
		for(int i : secondset) {
			if(checksosu(num*10+i) ==1) {
				sosu(cnt+1,num*10+i);
			}
		}
		return;
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		for(int i : firstset) {
			sosu(0,i);
		}
	}

}