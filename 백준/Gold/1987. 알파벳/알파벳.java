import java.io.*;
import java.util.*;

public class Main {

	static int R,C;
	static int[] passalphabet = new int[26];
	static char[][] field;
	static int ans = 0;
	static int[] di = {-1,0,1,0}; //상우하좌
	static int[] dj = {0,1,0,-1};
	
	public static int changealphabet(char chg) {
		int num = (int)chg -'A';
		return num;
	}
	
	public static void dfs(int r, int c,int d) {
		passalphabet[changealphabet(field[r][c])] = 1;
		int tmp = 0;
		for(int i=0;i<4;i++) {
			int ni = r + di[i];
			int nj = c + dj[i];
			if(ni>=0 && ni<R && nj>=0 && nj <C && passalphabet[changealphabet(field[ni][nj])]== 0) {
				passalphabet[changealphabet(field[ni][nj])]=1;
				dfs(ni,nj,d+1);
				passalphabet[changealphabet(field[ni][nj])]=0;
				tmp++;
			}
		}
		if(tmp == 0) {
			ans = Math.max(ans, d);
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		field = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String ts = br.readLine().trim();
			for(int j=0;j<C;j++) {
				field[i][j] = ts.charAt(j);
			}
		}
		dfs(0,0,1);
		System.out.println(ans);
	}

}
