import java.io.*;
import java.util.*;

public class Main {
	
	public static int[][] catscore;
	public static int N,K;
	public static int[] dp;
	
	public static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return -Integer.compare(o1[0], o2[0]);
		};
	});
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		catscore = new int[N][K];
		dp = new int[K];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<K;j++) {
				catscore[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		
		for(int j=0;j<K;j++) {
			dp[j] = catscore[0][j];
		}
		
		for(int i=1;i<N;i++) {
			pq.clear();
			for(int j=0;j<K;j++) {
				pq.offer(new int[] {catscore[i-1][j],j});
			}
			for(int j=0;j<K;j++) {
				int[] tmp = pq.poll();
				if(tmp[1] == j) {
					int[] tmp2 = pq.poll();
					catscore[i][j] += tmp2[0];
					pq.offer(tmp2);
				}
				else {
					catscore[i][j] += tmp[0];
				}
				pq.offer(tmp);
			}
		}
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(catscore[i]));
//		}
		System.out.println(Arrays.stream(catscore[N-1]).max().getAsInt());
	}

}