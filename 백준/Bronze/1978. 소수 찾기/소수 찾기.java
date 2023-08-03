import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		int M = 1000;
		
		int [] on = new int[M+1];
		Arrays.fill(on, 1);
		for(int i=2;i<=M;i++) {
			for(int j=1;j<=M/i;j++) {
				on[i*j] +=1;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		
		int ans = 0;
		for(int i=0;i<N;i++) {
			int tc = Integer.parseInt(st.nextToken());
			if(on[tc]==2) {
				ans+=1;
			}
		}
		System.out.println(ans);
	}

}