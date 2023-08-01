import java.io.*;
import java.util.Arrays;

public class Main{ 
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
		int M = 1000000;
		long[] barr = new long[M+1];
		long[] tmparr = new long[M+1];
		
		Arrays.fill(tmparr, 1);
		barr[1] = 1;
		
		for(int i=2;i<=M;i++) {
			for(int j=1; j<=M/i; j++) {
				tmparr[i*j] += i;
			}
			barr[i] = barr[i-1] + tmparr[i];
		}
		
		
		for(int tc = 0; tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
            sb.append(barr[N]).append("\n");
		}
        System.out.println(sb);
	}

}