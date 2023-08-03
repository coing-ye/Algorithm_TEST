import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
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
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		
		int sn = Integer.parseInt(st.nextToken());
		int en = Integer.parseInt(st.nextToken());
		for(int i = sn;i<=en;i++) {
			if(on[i] ==2) {
				System.out.println(i);
			}
		}
		
	}

}
