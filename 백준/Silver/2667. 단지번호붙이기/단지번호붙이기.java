import java.util.*;
import java.io.*;

public class Main {
	static int[][] dmap;
	static int N;
	static boolean[][] visited;
	static int[] di = {-1,0,1,0}, dj = {0,1,0,-1};
	
	public static int bfs(int r,int c) {
		visited[r][c] = true;
		ArrayDeque<int[]> deq = new ArrayDeque<>();
		deq.offer(new int[] {r,c});
		int cnt = 0;
		while(!deq.isEmpty()) {
			cnt +=1;
			int[] ij = deq.pop();
			int i = ij[0];
			int j = ij[1];
			for(int k=0;k<4;k++) {
				int ni = i+ di[k];
				int nj = j+ dj[k];
				if(ni>=0 && ni< N && nj>=0 && nj<N && visited[ni][nj]==false && dmap[ni][nj] !=0) {
					visited[ni][nj] = true;
					deq.offer(new int[] {ni,nj});
				}
			}
		}
		return cnt;
	}
	
	public static void printmap(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		dmap = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			String s = st.nextToken();
			for(int j=0;j<N;j++) {
				dmap[i][j] = s.charAt(j)-'0';
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] ==false && dmap[i][j] !=0) {
					int tmp = bfs(i,j);
					pq.offer(tmp);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while(pq.size()>1) {
			sb.append(pq.poll()).append("\n");
		}
		sb.append(pq.poll());
		System.out.println(sb);
	}
}
