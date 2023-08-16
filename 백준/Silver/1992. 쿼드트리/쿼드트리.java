import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] quard;
	static StringBuilder sb  = new StringBuilder();
	
	public static int getsum(int si,int sj,int size) {
		int cnt = 0;
		for(int i=si;i< si+size;i++) {
			for(int j=sj;j<sj+ size;j++) {
				cnt+=quard[i][j];
			}
		}
		return cnt;
	}
	
	public static void divide(int r, int c, int size) {
		sb.append("(");
		if(size == 1) {
			sb.append(Integer.toString(quard[r][c]));
			return;
		}
		for(int i = 0;i<2;i++) {
			for(int j=0;j<2;j++) {
				int gs = getsum(r+(i*size/2),c+(j*size/2),size/2);
				if (gs == size*size/4) sb.append("1");
				else if(gs == 0) sb.append("0");
				else {
					divide(r+(i*size/2),c+(j*size/2),size/2);
				}
			}
		}
		sb.append(")");
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		quard = new int[N][N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			String tmp = st.nextToken();
			for(int j = 0;j<N;j++) {
				quard[i][j] = Integer.parseInt(Character.toString(tmp.charAt(j)));
			}
		}
		
		if(getsum(0,0,N) == N*N) sb.append("1");
		else if (getsum(0,0,N) == 0) sb.append("0");
		else divide(0,0,N);

		System.out.println(sb);
		
	}

}
