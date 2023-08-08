import java.io.*;
import java.util.*;
public class Main {

	static int N,M,R;
	static int[][] ori;
	static int[][] chg;
	
	static int il,jl;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		ori = new int[N][M];
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<M;j++) {
				ori[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		il = N;
		jl = M;
		int si = 0;
		int ei = N-1;
		int sj = 0;
		int ej = M-1;
		StringBuilder sb = new StringBuilder();
		while(il>0 && jl>0) {
			ArrayDeque<Integer> arr = new ArrayDeque<>();
			for(int j=0;j<jl;j++) {
				arr.offer(ori[si][sj+j]);
			}
			for(int i=1;i<il-1;i++) {
				arr.offer(ori[si+i][ej]);
			}
			if(il>1) {
				for(int j=jl-1;j>=0;j--) {
					arr.offer(ori[ei][sj+j]);
				}
			}
			for(int i=il-2;i>0;i--) {
				arr.offer(ori[si+i][sj]);
			}
			
			for(int k = 0;k<R;k++) {
				int tmp = arr.pollFirst();
				arr.offer(tmp);
			}
			
			
			for(int j=0;j<jl;j++) {
				ori[si][si+j] = arr.pollFirst();
			}
			for(int i=1;i<il-1;i++) {
				ori[si+i][ej] = arr.pollFirst();
			}
			if(il>1) {
				for(int j=jl-1;j>=0;j--) {
					ori[ei][sj+j] = arr.pollFirst();
				}
			}
			for(int i=il-2;i>0;i--) {
				ori[si+i][sj] = arr.pollFirst();
			}
			
			
			il = il- 2;
			jl = jl- 2;
			si = si+1;
			sj = sj+1;
			ei = ei-1;
			ej = ej-1;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(ori[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
