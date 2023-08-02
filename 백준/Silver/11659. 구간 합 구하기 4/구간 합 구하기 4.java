import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int[] arr = new int[N];
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		for(int i=0;i<N;i++) {
			dp[i+1] = dp[i]+arr[i];
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int s  = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int anw = 0;
			anw = dp[e] - dp[s-1];
			sb.append(anw).append("\n");
		}
		System.out.println(sb);
	}

}
