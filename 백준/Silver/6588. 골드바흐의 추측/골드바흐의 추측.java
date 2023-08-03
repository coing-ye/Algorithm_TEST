import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int M = 1000000;
		
		int [] on = new int[M+1];
		Arrays.fill(on, 1);
		for(int i=2;i<=M;i++) {
			for(int j=1;j<=M/i;j++) {
				on[i*j] +=1;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int in = Integer.parseInt(br.readLine().trim());
		while(in!=0) {
			//System.out.println(in);
			int flag = 1;
			for(int i=1;i<=in/2;i++) {
				if(on[i]==2 && on[in-i]==2) {
					sb.append(in).append(" = ").append(i).append(" + ").append(in-i).append("\n");
					flag = 0;
					break;
				}
			}
			if(flag==1) {
				sb.append("Goldbach's conjecture is wrong.\n");
			}
			in = Integer.parseInt(br.readLine().trim());
		}
		System.out.println(sb);
	}

}
