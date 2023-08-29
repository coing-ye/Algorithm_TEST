import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] field;
	public static boolean[][] visited;
	public static int[] di = {-1,0,1,0}; //상우하좌
	public static int[] dj = {0,1,0,-1};
	public static int ans = 0;
	public static int[][] dpfield;
	public static int totalnum;
	public static int countnum;
	public static PriorityQueue<int[]> locate = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[0] != o2[0]) {
				return -Integer.compare(o1[0], o2[0]);
			}
			else{
				if(o1[1] != o2[1]) {
					return -Integer.compare(o1[1], o2[1]);
				}
				else {
					if(o1[2]!= o2[2]) {
						return -Integer.compare(o1[2], o2[2]);
					}
				}
			}
			return 0;
		}
	});
	
	public static void printdp() {
		for(int i = 0;i<N;i++) {
			System.out.println(Arrays.toString(dpfield[i]));
		}
		System.out.println("=======================");
	}
	public static void findbig(int r, int c) {
		ans = Math.max(ans, dpfield[r][c]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int d=0;d<4;d++) {
			int ni = r + di[d];
			int nj = c + dj[d];
			if(ni>=0 && ni< N && nj>=0 && nj<N && field[ni][nj] > field[r][c] && dpfield[ni][nj] >= dpfield[r][c]) {
				pq.offer(dpfield[ni][nj]);
			}
			if(pq.size()>0) {
				dpfield[r][c] = pq.poll()+1;
			}
		}
		//printdp();
	}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		field = new int[N][N];
		visited = new boolean[N][N];
		dpfield = new int[N][N];
		totalnum = N*N;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int j=0;j<N;j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				dpfield[i][j] = 1;
				locate.offer(new int[] {field[i][j],i,j});
			}
		}
		while(!locate.isEmpty()) {
			int[] now = locate.poll();
			//System.out.println(now[0]+ " "+now[1]+" "+now[2]);
			findbig(now[1],now[2]);
			ans = Math.max(ans,dpfield[now[1]][now[2]]);
		}
		
		//printdp();
		System.out.println(ans);
	}

}