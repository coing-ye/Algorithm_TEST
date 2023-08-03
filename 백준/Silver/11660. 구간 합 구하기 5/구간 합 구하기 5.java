import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int[][] arr = new int[N][N];
		int[] dpi = new int[N*N+1];
		int[] dpj = new int[N*N+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dpi[0] = 0;
		dpj[0] = 0;
		for(int i=0;i<N*N;i++) {
			dpi[i+1] = arr[i/N][i%N]+dpi[i];
			dpj[i+1] = arr[i%N][i/N]+dpj[i];
			//System.out.print(dp[i]+ " ");
		}
//		System.out.println();
		for(int tc = 1; tc<=M;tc++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int si = Integer.parseInt(st.nextToken())-1;
			int sj = Integer.parseInt(st.nextToken())-1;
			int ei = Integer.parseInt(st.nextToken())-1;
			int ej = Integer.parseInt(st.nextToken())-1;
			
			int anw = 0;
//			System.out.println();
//			System.out.println(tc);
			anw = dpi[ei*N+ej+1]-dpi[si*N+sj];
			if(ei>si) {
				for(int i=sj-1;i>=0;i--) {
					int lt = (dpj[i*N+ei+1] - dpj[i*N+si+1]);
					anw = anw - lt;
					//System.out.println("lt "+lt);
				}

				for(int i = ej+1; i<N;i++) {
					int rt = (dpj[i*N+ei] - dpj[i*N+si]);
					anw = anw - rt;
					//System.out.println("rt "+rt);
				}
			}
			
			//System.out.println(anw);
			sb.append(anw).append("\n");
			
		}
		System.out.println(sb);
	}

}