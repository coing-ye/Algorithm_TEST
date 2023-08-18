import java.io.*;
import java.util.*;

public class Main {
	static int H,W;
	static int[][] field;
	static boolean[][] visited;
	static ArrayDeque<int[]> deq = new ArrayDeque<>();
	static int[] di = {-1,-1,0,1,1, 1, 0,-1}; //상,상우,우,하우,하,하좌,좌,상좌
	static int[] dj = { 0, 1,1,1,0,-1,-1,-1};
	
	public static void printfield() {
		for(int i = 0; i<H;i++) {
			System.out.println(Arrays.toString(field[i]));
		}
		System.out.println("---------------------------");
	}
	
	
	public static void bfs(int r,int c) {
		visited[r][c] = true;
		deq.offer(new int[] {r,c});
		while(!deq.isEmpty()) {
			int[] now = deq.poll();
			int nr = now[0];
			int nc = now[1];
			for(int i=0;i<8;i++) {
				int ni = nr + di[i];
				int nj = nc + dj[i];
				if(ni>=0 && ni<H && nj>=0 && nj<W && visited[ni][nj]==false && field[ni][nj]==1) {
					visited[ni][nj] = true;
					deq.offer(new int[] {ni,nj});
				}
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		do {
			st = new StringTokenizer(br.readLine().trim()," ");
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			field = new int[H][W];
			visited = new boolean[H][W];
			for(int i= 0;i<H;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				for(int j = 0; j<W;j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			int tmp = 0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(field[i][j] == 1 && visited[i][j] == false) {
						bfs(i,j);
						tmp+=1;
					}
				}
			}
			if(H==0 && W==0) continue;
			//printfield();
			sb.append(tmp).append("\n");
			//printfield();
		}while(H!=0 && W!=0);
		System.out.println(sb);
	}

}